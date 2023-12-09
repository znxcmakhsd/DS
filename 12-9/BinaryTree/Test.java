package BinaryTree;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        //binaryTree.preOrder(root);
        //binaryTree.inOrder(root);
        //binaryTree.postOrder(root);

        //binaryTree.size(root);
        //System.out.println(binaryTree.nodeSize);
        //System.out.println(binaryTree.size2(root));
        /*binaryTree.getLeafNodeCount1(root);
        System.out.println(binaryTree.LeafNodeNum);
        System.out.println("====");
        System.out.println(binaryTree.getLeafNodeCount2(root));*/
        System.out.println(binaryTree.getKLevelNodeCount(root,3));
    }
}
