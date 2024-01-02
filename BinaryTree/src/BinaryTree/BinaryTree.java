package BinaryTree;

public class BinaryTree {

    static class TreeNode {
        public TreeNode left;
        public char val;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    // 手动创建一棵树
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
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    // 1. 前序遍历 (根左右) - 递归实现
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // 2. 中序遍历 (根左右) - 递归实现
    // 左根右
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // 3. 后序遍历 (根左右) - 递归实现
    // 左右根
    public void postOrder(TreeNode  root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    // 4. 获取树中节点的个数 - 遍历思路
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
    // 思路: 树中节点的个数 = 左树节点的个数 + 右树节点的个数 + 1(根)
    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.left)
                + size2(root.right) + 1;
    }
    // 4. 获取叶子节点的个数 - 遍历思路
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

    // 4. 获取叶子节点的个数 - 子问题思路
    // 思路: 一颗树的叶子节点的个数 = 左树的叶子节点个数 + 右树的叶子节点个数
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

    // 获取第K层节点的个数
    //int getKLevelNodeCount(TreeNode root,int k);

}
