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
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }
    // 前序遍历 (根左右) - 递归实现
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // 中序遍历 (左根右) - 递归实现
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // 后序遍历 (左右根) - 递归实现
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // 前序遍历 (根左右) - 非递归实现
    public void preOrderNor(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }
    // 中序遍历 (左根右) - 非递归实现
    public void inOrderNor(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }
    // 后序遍历 (左右根) - 非递归实现
    /*public void postOrderNor(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            cur = top.right;
            if (cur == null) {
                stack.pop();
                System.out.print(top.val + " ");
            }
        }
    }*/

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        // 递归实现遍历
        System.out.println("递归实现遍历: ");
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();

        System.out.println("==================");

        System.out.println("非递归实现遍历: ");
        binaryTree.preOrderNor(root);
        System.out.println();
        binaryTree.inOrderNor(root);
        System.out.println();
        //binaryTree.postOrderNor(root);
    }
}
