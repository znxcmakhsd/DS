1. 从中序与后序遍历序列构造二叉树
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /*static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }*/

    public int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIndex = postorder.length-1;
        return buildTreeChild(inorder,postorder,0,this.postIndex);
    }

    public TreeNode buildTreeChild(int[] inorder, int[] postorder,int inBegin,int inEnd) {
        if (inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int rootIndex = findRootIndex(inorder,inBegin,inEnd,root.val);
        this.postIndex--;
        root.right = buildTreeChild(inorder,postorder,rootIndex+1,inEnd);
        root.left = buildTreeChild(inorder,postorder,inBegin,rootIndex-1);
        return root;
    }
    public int findRootIndex(int[] inorder,int inBegin,int inEnd,int key) {
        for (int i = inBegin;i <= inEnd;i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}

2. 根据二叉树创建字符串
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        buildString(root,stringBuilder);
        return stringBuilder.toString();
    }
    public void buildString(TreeNode root,StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val);
        if (root.left != null) {
            stringBuilder.append("(");
            buildString(root.left,stringBuilder);
            stringBuilder.append(")");
        }else {
            // 两种情况:
            // 1. 左右都为空
            if (root.right == null) {
                return;
            }else {
                // 2. 左为空 右不为空
                stringBuilder.append("()");
            }
        }
        if (root.right != null) {
            stringBuilder.append("(");
            buildString(root.right,stringBuilder);
            stringBuilder.append(")");
        }else {
            // 右边为空 直接返回
            return;
        }
    }
}
3. 二叉树的前序遍历
递归:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.add(root.val);

        List<Integer> leftTree = preorderTraversal(root.left);
        list.addAll(leftTree);

        List<Integer> rightTree = preorderTraversal(root.right);
        list.addAll(rightTree);

        return list;
    }
}

// 4. 非递归实现前序遍历
    public void preOrderNor(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

//5.  非递归实现中序遍历
    public void inOrderNor(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val+" ");
            cur = top.right;
        }
    }