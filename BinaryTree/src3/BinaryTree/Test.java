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

        // 5. 测试 获取树中叶子节点的个数
       /* binaryTree.getLeafNodeCount1(root);
        System.out.println(binaryTree.leafNodeNum);
        System.out.println(binaryTree.getLeafNodeCount2(root));*/

        // 6. 测试 获取第K层节点的个数
        /*System.out.println(binaryTree.getKLevelNodeCount(root, 3));
        System.out.println(binaryTree.getKLevelNodeCount(root, 4));*/

        // 7. 测试 获取二叉树的高度
        //System.out.println(binaryTree.getHeight(root));

        // 8. 测试 检测值为value的元素是否存在
        //System.out.println(binaryTree.find(root, 'H'));
        //System.out.println(binaryTree.find(root, 'G'));

        // 14. 测试 根据前序遍历创建一颗二叉树
        /*String str = "abc##de#g##f###";
        BinaryTree.TreeNode root2 = binaryTree.createTree(str);*/

        // 15. 测试 层序遍历
        //binaryTree.levelOrder(root);

    }
}
