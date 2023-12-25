package Test;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        /*System.out.println("节点个数: "+binaryTree.size(root));
        System.out.println("叶子节点个数: "+binaryTree.getLeafNodeCount(root));
        System.out.println("第k层节点个数: "+binaryTree.getKLevelNodeCount(root,4));*/
        //System.out.println(binaryTree.getHeight(root));
        System.out.println(binaryTree.find(root, 'H'));
    }
}
