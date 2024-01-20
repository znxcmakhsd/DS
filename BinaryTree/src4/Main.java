public class Main {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();

        // 1. 递归实现前中后序遍历
       /* binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);*/

        // 2. 获取树中节点的个数 - 遍历思路
        /*binaryTree.size1(root);
        System.out.println(binaryTree.nodeNum);
        System.out.println(binaryTree.size2(root));*/

        // 3. 获取叶子节点的个数
        /*binaryTree.getLeafNodeCount1(root);
        System.out.println(binaryTree.leafNodeNum);
        System.out.println(binaryTree.getLeafNodeCount2(root));*/

        // 4. 获取第K层节点的个数
        //System.out.println(binaryTree.getKLevelNodeCount(root, 1));

        // 5. 获取二叉树高度
        //System.out.println(binaryTree.getHeight(root));

        // 6. 检测值为value的元素是否存在
        //System.out.println(binaryTree.find(root, 'H'));

        // 13. 测试 层序遍历
        //binaryTree.levelOrder(root);

        System.out.println(binaryTree.isCompleteTree(root));
    }
}