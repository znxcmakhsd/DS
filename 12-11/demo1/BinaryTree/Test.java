package BinaryTree;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        //binaryTree.preOrder(root);

        // 1. 测试 获取树中节点的个数 - 前序遍历思路
       /* binaryTree.sizeF(root);
        System.out.println(binaryTree.TreeNodeNum);*/

        // 1. 测试 获取树中节点的个数 - 中序遍历思路
        /*binaryTree.sizeM(root);
        System.out.println(binaryTree.TreeNodeNum2);*/

        // 1. 测试 获取树中节点的个数 - 后序遍历思路
        /*binaryTree.sizeB(root);
        System.out.println(binaryTree.TreeNodeNum3);*/

        // 1. 测试 获取树中节点的个数 - 子问题思路
        // 左子树节点个数 + 右子树节点个数 + 1 = 总节点个数
        //System.out.println(binaryTree.sizeS(root));


        // 2. 测试 获取树中叶子节点的个数 - 遍历思路
        /*binaryTree.size(root);
        System.out.println(binaryTree.TreeNodeNum);*/

        // 2. 测试 获取叶子节点的个数 - 子问题思路
        /*System.out.println("叶子节点的个数: ");
        System.out.println(binaryTree.getLeafNodeCount2(root));*/

        // 3. 测试 获取获取第K层节点的个数
       /* System.out.println("第K层节点的个数: ");
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));*/

        // 4. 测试 获取二叉树的高度
        /*System.out.println("获取二叉树的高度: ");
        System.out.println(binaryTree.getHeight(root));*/

        // 5. 检测值为value的元素是否存在
        /*BinaryTree.TreeNode ret = binaryTree.find(root,'E');
        System.out.println(ret.value);*/

        BinaryTree.TreeNode p = binaryTree.Tree1();
        BinaryTree.TreeNode q = binaryTree.Tree2();
        System.out.println(binaryTree.isSameTree(p, q));
    }
}
