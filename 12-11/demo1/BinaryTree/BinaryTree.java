package BinaryTree;

public class BinaryTree {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    // 手动链接
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

    // 前序遍历
    public void preOrder(TreeNode root) {
      // 根 ——》 左子树 ——》 右子树
      if (root == null) {
          return;
      }
      System.out.print(root.value + " ");
      preOrder(root.left);
      preOrder(root.right);
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        // 左 ——》 根 ——》 右
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        // 左 ——》 右 ——》 根
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    // 获取树中节点的个数 - 前序遍历思路
    public int TreeNodeNum1;
    public void sizeF(TreeNode root) {
        if (root == null) {
            return;
        }
        this.TreeNodeNum1++;
        sizeF(root.left);
        sizeF(root.right);
    }
    // 获取树中节点的个数 - 中序遍历思路
    public int TreeNodeNum2;
    public void sizeM(TreeNode root) {
        if (root == null) {
            return;
        }
        sizeM(root.left);
        this.TreeNodeNum2++;
        sizeM(root.right);
    }
    // 获取树中节点的个数 - 后序遍历思路
    public int TreeNodeNum3;
    public void sizeB(TreeNode root) {
        if (root == null) {
            return;
        }
        sizeB(root.left);
        sizeB(root.right);
        this.TreeNodeNum3++;
    }

    // 获取树中节点的个数 - 子问题思路
    // 左子树节点个数 + 右子树节点个数 + 1(根) = 总节点个数
    public int sizeS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sizeS(root.left)
                + sizeS(root.right) + 1;
    }

    // 获取叶子节点的个数 - 遍历思路
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
    // 获取叶子节点的个数 - 子问题思路
    // 左子树的叶子节点 + 右子树的叶子节点
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
    // 左子树高度 与 右子树高度的 最大值 + 根1 = 二叉树高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = getHeight(root.left);
        int rightTreeHeight = getHeight(root.right);
        return Math.max(leftTreeHeight,rightTreeHeight)+ 1;
    }

    // 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, int val) {
        if (root == null) return null;

        if (root.value == val) return root;

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

    public TreeNode Tree1() {
        TreeNode A = new TreeNode(4);
        TreeNode B = new TreeNode(1);
        TreeNode C = new TreeNode(2);
        TreeNode D = new TreeNode(0);
        A.left = B;
        A.right = C;
        C.left = D;
        return A;
    }
    public TreeNode Tree2() {
        TreeNode A = new TreeNode(4);
        TreeNode B = new TreeNode(1);
        TreeNode C = new TreeNode(2);
        A.left = B;
        A.right = C;
        return A;
    }

    //  判断 2棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1个为空 1个不为空
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        // 走到这表示 都为空 / 都不为空
        // 如果为空 表示这两棵树 没有节点 ——》 true
        if (p == null && q == null) {
            return true;
        }
        // 如果都不为空 则判断值是否相等
        // 值不相等 ——》 false  值相等 ——》
        if (p.value != q.value) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
