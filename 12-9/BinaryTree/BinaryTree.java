package BinaryTree;

public class BinaryTree {
    static class TreeNode {
        public char value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char value) {
            this.value = value;
        }
    }

    // 手动连接
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

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            //System.out.print("null ");
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // 中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }
    // 后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public int nodeSize;
    // 获取树中节点的个数 - 计数器
    public void size(TreeNode root) {
        if (root == null) {
            return;
        }
        this.nodeSize++;
        size(root.left);
        size(root.right);
    }

    // 获取树中节点的个数 - 子问题
    // 左子树 + 右子树 + 1
    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.left) + size2(root.right) + 1;
    }

    public int LeafNodeNum;
    // 获取叶子节点的个数 - 遍历
    public void getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            this.LeafNodeNum++;
            return;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);

    }

    // 获取叶子节点的个数 - 子问题思路 左树叶子节点 + 右树叶子节点
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

    // 获取二叉树的高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

    }


}
