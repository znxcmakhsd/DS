import java.util.*;

public class BinaryTree {

    static class TreeNode {
        public TreeNode left;
        public char val;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        B.left = D;
        B.right = E;
        //E.right = H;
        A.right = C;
        C.left = F;
        C.right = G;
        return A;
    }

    // 1. 前序 - 递归实现
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 1. 中序 - 递归实现
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 1. 后序 - 递归实现
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // 2. 获取树中节点的个数 - 计数器思路
    public int nodeNum;

    public void size1(TreeNode root) {
        if (root == null) {
            return;
        }
        this.nodeNum++;
        size1(root.left);
        size1(root.right);
    }

    // 2. 获取树中节点的个数 - 子问题思路
    // 每棵树节点个数 = 左树节点个数 + 右树节点个数 + 1(根)
    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.left)
                + size2(root.right) + 1;
    }

    // 3. 获取叶子节点的个数 - 计数器思路
    public int leafNodeNum;

    public void getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            this.leafNodeNum++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }

    // 3. 获取叶子节点的个数 - 子问题思路
    // 左树叶子节点个数 + 右树叶子节点个数
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

    // 4. 获取第K层节点的个数
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1)
                + getKLevelNodeCount(root.right, k - 1);
    }

    // 5. 获取二叉树的高度
    // 二叉树的高度 = 左子树高度与右子树高度的最大值 + 1(根的高度)
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 6. 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftVal = find(root.left, val);
        if (leftVal != null) {
            return leftVal;
        }
        TreeNode rightVal = find(root.right, val);
        if (rightVal != null) {
            return rightVal;
        }
        return null;
    }

    // 7. 判断是否是相同的树
    // https://leetcode.cn/problems/same-tree/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如何判断两颗树是否相同? 根相同 + 左右子树相同
        // 如何判断根相同? 结构 + 值相同
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        // 走到这说明根相同 接下来判断左右子树是否相同
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    // 8. 判断一颗树是否是另一颗树的子树
    // https://leetcode.cn/problems/subtree-of-another-tree/description/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        if (isSubtree(root.left, subRoot)) {
            return true;
        }

        if (isSubtree(root.right, subRoot)) {
            return true;
        }

        return false;
    }

    // 9. 翻转一颗二叉树
    // https://leetcode.cn/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    // 10. 判断一颗树是否是平衡二叉树
    // https://leetcode.cn/problems/balanced-binary-tree/

    // 方法1: O(N^2)
    /*public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        if (Math.abs(leftH - rightH) <= 1
                && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }*/

    // 方法2: O(N)
    // 注意:  字节跳动考过这个解法
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }
    public int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getHeight2(root.left);
        int rightH = getHeight2(root.right);
        if (leftH >= 0 && rightH >= 0 && Math.abs(leftH - rightH) <= 1) {
            return Math.max(leftH,rightH) + 1;
        }else {
            return -1;
        }
    }

    // 11. 判断对称二叉树
    // https://leetcode.cn/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if (leftTree == null && rightTree != null
                || leftTree != null && rightTree == null) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right)
                && isSymmetricChild(leftTree.right,rightTree.left);
    }

    // 12. 前序遍历创建二叉树
    // https://www.nowcoder.com/practice/4b91205483694f449f94c179883c1fef?tpId=60&&tqId=29483&rp=1&ru=/activity/oj&qru=/ta/tsing-kaoyan/question-ranking
    public int i;
    public TreeNode createTree(String str) {
        TreeNode root = null;
        char ch = str.charAt(i);
        if (ch != '#') {
            root = new TreeNode(ch);
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else {
            i++;
        }
        return root;
    }

    // 13. 层序遍历
    public void levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val+" ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    // 14. 数组存储 层序 遍历结果
    // https://leetcode.cn/problems/binary-tree-level-order-traversal/description/

    /*public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> array = new ArrayList<>();
            while (sz != 0) {
                TreeNode cur = queue.poll();
                array.add(cur.val);
                sz--;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            retList.add(array);
        }
        return retList;
    }*/

    // 15. 判断一棵树是否是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != null) {
                return false;
            }
        }
        return true;
    }

    // 16. 找两个节点的最近公共祖先
    // https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }else if (left != null){
            return left;
        }else {
            return right;
        }
    }*/
    public boolean getPathNode(Stack<TreeNode> stack, TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        stack.push(root);
        if (stack.peek() == node) {
            return true;
        }
        if (getPathNode(stack,root.left,node)) {
            return true;
        }
        if (getPathNode(stack,root.right,node)) {
            return true;
        }
        stack.pop();
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();
        getPathNode(stackA,root,p);
        getPathNode(stackB,root,q);

        if (stackA.size() > stackB.size()) {
            int sz = stackA.size() - stackB.size();
            while (sz != 0) {
                stackA.pop();
                sz--;
            }
        }else {
            int sz = stackB.size() - stackA.size();
            while (sz != 0) {
                stackB.pop();
                sz--;
            }
        }

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                return stackA.peek();
            }else {
                stackA.pop();
                stackB.pop();
            }
        }
        return null;
    }

    // 17. 前序和中序遍历构造二叉树
    /*public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
    public int preIndex;
    public TreeNode buildTreeChild(int[] preorder, int[] inorder,int inbegin,int inend) {
        if (inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int rootIndex = findRootIndex(inorder,inbegin,inend,root.val);
        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex - 1);
        root.right = buildTreeChild(preorder,inorder,rootIndex + 1,inend);
        return root;
    }
    public int findRootIndex(int[] inorder,int inbegin,int inend,int key) {
        for (int i = inbegin;i <= inend;i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }*/

}


