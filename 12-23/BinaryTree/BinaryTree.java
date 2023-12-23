package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    static class TreeNode {
        private TreeNode left;
        public char val;
        private TreeNode right;

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
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    // 1. 把前序遍历的结果存起来
    public List<Character> preorderTraversal(TreeNode root) {
        List<Character> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);

        List<Character> leftTree = preorderTraversal(root.left);
        list.addAll(leftTree);

        List<Character> rightTree = preorderTraversal(root.right);
        list.addAll(rightTree);
        return list;
    }
    // 1. 中序遍历 - 左根右
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    // 1. 后序遍历 - 左右根
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");

    }
    // 2. 获取树中节点的个数 - 前序遍历思路
    public int countNode;
    public void size1(TreeNode root) {
        if (root == null) {
            return;
        }
        countNode++;
        size1(root.left);
        size1(root.right);
    }

    // 2. 获取树中节点的个数 - 子问题思路
    // 一颗树的节点个数 = 左子树节点个数 + 右子树节点个数 + 1(根)
    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.left) +size2(root.right) + 1;
    }

    // 3.获取叶子节点的个数 - 前序遍历思路
    public int leafNodeNum;
    public void getLeafNodeCount1(TreeNode root){
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafNodeNum++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }
    // 3. 获取叶子节点的个数 - 子问题思路
    // 左子树叶子节点个数 + 右子树叶子节点个数 = 总叶子节点的个数
    public int getLeafNodeCount2(TreeNode root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return getLeafNodeCount2(root.left) +
                getLeafNodeCount2(root.right);
    }
    // 4. 获取第K层节点的个数
    // = 左树k层节点个数 + 右树k层节点个数
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
    // 5. 获取二叉树的高度
    // 整颗树的高度 = 左子树高度与右子树高度的最大值 + 1
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = getHeight(root.left);
        int rightTreeHeight = getHeight(root.right);
        return leftTreeHeight > rightTreeHeight
                ? leftTreeHeight + 1 : rightTreeHeight + 1;
    }
    // 6. 检测值为value的元素是否存在 (假设不重复)
    public TreeNode find(TreeNode root, char val) {
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
    // 7. 判断两颗树是否相同
    // 假设节点个数不一样: p节点个数 m, q节点个数 n
    // 时间复杂度: min(m,n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 判断根:
        if (p == null && q != null || q == null && p != null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        // 判断左树和右树:
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
