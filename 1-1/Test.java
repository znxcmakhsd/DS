package BinaryTree;

import java.util.Stack;

public class BinaryTree {

    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public char val;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {
        TreeNode B = new TreeNode('B');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode H = new TreeNode('H');

        B.left = D;
        B.right = E;
        E.right = H;
        return B;
    }
    // 1. 前序遍历 (根左右) - 递归实现
    public void preOrder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // 1. 中序遍历 (左根右) - 递归实现
    public void inOrder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // 1. 后序遍历 (左右根) - 递归实现
    public void postOrder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    // 2. 前序遍历 (根左右) - 非递归实现
    public void preOrderNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                // 访问根节点
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }
    // 2. 中序遍历 (左根右) - 非递归实现
    public void inOrderNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            // 访问根节点
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

     // 2. 后序遍历 (左根右) - 非递归实现
    public void postOrderNor(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();

            if (top.right == null || top.right == prev) {
                System.out.print(top.val + " ");
                prev = top;
                stack.pop();
            }else {
                cur = top.right;
            }
        }
     }

    // 3. 获取树中节点的个数 - 遍历思路
    public int nodeNum;
    public void size1(TreeNode root) {
        if (root == null) {
            return;
        }
        this.nodeNum++;
        size1(root.left);
        size1(root.right);
    }
    // 3. 获取树中节点的个数 - 子问题思路
    // 一颗树的节点个数 = 左子树节点个数 + 右子树节点个数 + 1(根)
    public int size2(TreeNode root) {
       if (root == null) {
           return 0;
       }
       return size2(root.left)
               + size2(root.right) + 1;
    }
    // 4. 获取叶子节点的个数 - 遍历思路
    public int LeafNodeNum;
    public void getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            this.LeafNodeNum++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }
    // 4. 获取叶子节点的个数 - 子问题思路
    // 一棵树的叶子节点的个数 = 左树叶子节点个数 + 右树叶子节点个数
    public int getLeafNodeCount2(TreeNode root) {
       if (root == null) {
           return 0;
       }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left)
                + getLeafNodeCount2(root.right);
    }
    // 5. 获取第K层节点的个数
    public int getKLevelNodeCount(TreeNode root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)
                + getKLevelNodeCount(root.right,k-1);

    }
    // 6. 获取二叉树的高度
    // 二叉树的高度 = 左子树与右子树高度最大值 + 1
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right) + 1;
    }

    // 7. 检测值为value的元素是否存在
    TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        TreeNode left = find(root.left,val);
        if (left != null) {
            return left;
        }
        TreeNode right = find(root.right,val);
        if (right != null) {
            return right;
        }

        return null;
    }

}
