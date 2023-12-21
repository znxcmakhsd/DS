package BinaryTree;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        // 前序:
        //binaryTree.preOrder(root);
        // 中序:
        //binaryTree.inOrder(root); // D B E H A F C G
        // 后序:
        //binaryTree.postOrder(root); // D H E B F G C A
        System.out.println(binaryTree.size(root));;


    }
}
