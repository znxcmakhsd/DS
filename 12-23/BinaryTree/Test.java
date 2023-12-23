package BinaryTree;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        /*binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root); // D B E H A F C G
        System.out.println();
        binaryTree.postOrder(root); // D H E B F G C A*/
        //System.out.println(binaryTree.size(root));;
        //binaryTree.preorderTraversal(root);

        // 测试获取树中节点的个数
        /*binaryTree.size1(root);
        System.out.println(binaryTree.countNode);*/
        //System.out.println(binaryTree.size2(root));

        // 测试获取叶子节点的个数
        //System.out.println(binaryTree.getLeafNodeCount2(root));

        // 测试获取第K层节点的个数
        //System.out.println(binaryTree.getKLevelNodeCount(root,4));

        // 测试获取二叉树的高度
        //System.out.println(binaryTree.getHeight(root));

        // 测试 value的元素是否存在
        System.out.println(binaryTree.find(root, 'G'));
    }
}
