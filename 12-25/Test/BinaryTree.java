package Test;

import java.util.ArrayList;
import java.util.List;

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
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    // 1. 前序遍历 - 根左右
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 2. 中序遍历 - 左根右
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // 3. 后序遍历 - 左右根
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // 获取树中节点的个数
    // 思路: 整颗树中节点的个数 = 根 + 左子树 + 右子树
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // 子问题思路-求叶子结点个数
    // 树的叶子结点个数 = 左子树叶子结点个数 + 右子树叶子结点个数
    public int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount(root.left)
                + getLeafNodeCount(root.right);

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
    // 树的高度 = 左子树与右子树的最大值 + 1
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeHeight = getHeight(root.left);
        int rightTreeHeight = getHeight(root.right);

        return leftTreeHeight > rightTreeHeight
                ? leftTreeHeight+1 : rightTreeHeight+1;

    }
    // 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        //
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 不相同情况:
        // 一个根为空 一个根不为空
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        // 走到这说明 两个根都为空 或者 都不为空
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        // 走到这说明根相同 接下来判断左右子树是否相同
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
