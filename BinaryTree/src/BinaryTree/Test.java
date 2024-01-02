package BinaryTree;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        // 1.2.3 测试 前序中序后序 - 递归实现
      /*  binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);*/

        // 4. 测试 获取树中节点的个数
       /* binaryTree.size1(root);
        System.out.println(binaryTree.nodeNum);
        System.out.println(binaryTree.size2(root));*/

        // 5. 测试 获取树中节点的个数
        binaryTree.getLeafNodeCount1(root);
        System.out.println(binaryTree.leafNodeNum);
        System.out.println(binaryTree.getLeafNodeCount2(root));

    }
}
