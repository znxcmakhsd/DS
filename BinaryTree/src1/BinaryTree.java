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
        E.right = H;
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

    // 2. 获取树中节点的个数 - 遍历思路
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

    // 3. 获取叶子节点的个数 - 遍历思路
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
    public int getKLevelNodeCount(TreeNode root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)
                +  getKLevelNodeCount(root.right,k-1);
    }
    // 5. 获取二叉树的高度
    // 二叉树的高度 = 左子树高度与右子树高度的最大值 + 1(根的高度)
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }

    // 6. 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        TreeNode leftVal = find(root.left,val);
        if (leftVal != null) {
            return leftVal;
        }
        TreeNode rightVal = find(root.right,val);
        if (rightVal != null) {
            return rightVal;
        }
        return null;
    }

    // 7. 判断是否是相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}

}
