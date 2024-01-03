package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    static class TreeNode {
        public TreeNode left;
        public char val;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    // 手动创建一棵树
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

    // 1. 前序遍历 (根左右) - 递归实现
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // 1.
    public List<Character> preorderTraversal(TreeNode root) {
        List<Character> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);

        List<Character> left = preorderTraversal(root.left);
        list.addAll(left);

        List<Character> right = preorderTraversal(root.right);
        list.addAll(right);
        return list;
    }

    // 2. 中序遍历 (根左右) - 递归实现
    // 左根右
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // 3. 后序遍历 (根左右) - 递归实现
    // 左右根
    public void postOrder(TreeNode  root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    // 4. 获取树中节点的个数 - 遍历思路
    public int nodeNum;
    public void size1(TreeNode root) {
        if (root == null) {
            return;
        }
        this.nodeNum++;
        size1(root.left);
        size1(root.right);
    }
    // 4. 获取树中节点的个数 - 子问题思路
    // 思路: 树中节点的个数 = 左树节点的个数 + 右树节点的个数 + 1(根)
    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.left)
                + size2(root.right) + 1;
    }
    // 5. 获取叶子节点的个数 - 遍历思路
    public int leafNodeNum;
    public void getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            this.leafNodeNum++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }

    // 5. 获取叶子节点的个数 - 子问题思路
    // 思路: 一颗树的叶子节点的个数 = 左树的叶子节点个数 + 右树的叶子节点个数
    public int getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left)
                + getLeafNodeCount2(root.right);
    }

    // 6. 获取第K层节点的个数
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

    // 7. 获取二叉树的高度 - O(N)
    // 树的高度 = 左子树与右子树的最大值 + 1(根)
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }

    // 8. 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftVal = find(root.left,val);
        if (leftVal != null) {
            return leftVal;
        }
        TreeNode rightVal = find(root.right,val);
        if (rightVal != null) {
            return rightVal;
        }
        return null;
    }

    // 9. 判断两颗树是否相同
    // q节点个数 -> m  p节点个数 -> n
    // 时间复杂度: min(m,n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 一个为空 一个不为空
        if (p != null && q == null || p == null && q != null) {
            return false;
        }
        // 走到这说明 都为空 或者 都不为空
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        // 走到这说明根相同 最后判断左右子树是否相同
        return isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }

    // 10. 判断一棵树是否是另一棵树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root,subRoot)) {
            return true;
        }
        if (isSubtree(root.left,subRoot)) {
            return true;
        }
        if (isSubtree(root.right,subRoot)) {
            return true;
        }
        return false;
    }

    // 11. 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // 12. 判断一颗树是否是一颗平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int gap = leftHeight - rightHeight;

        if (Math.abs(gap) > 1) {
            return false;
        }
        boolean left = isBalanced(root.left);
        if (left == false) {
            return false;
        }
        boolean right = isBalanced(root.right);
        if (right == false) {
            return false;
        }
        return true;
    }

    // 13. 判断一颗树是否为对称二叉树
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        // 首先判断根
        // 一个为空 一个不为空 —— 不对称
        if (leftTree == null && rightTree != null || leftTree != null && rightTree == null) {
            return false;
        }
        // 走到这说明都为空 或者 都不为空
        if (leftTree == null && rightTree == null) {
            return true;
        }
        // 都不为空判断值
        if (leftTree.val != rightTree.val) {
            return false;
        }
        // 走到这说明左子树与右子树的根对称
        // 接下来判断左右子树是否对称
        return isSymmetricChild(leftTree.left,rightTree.right)
                && isSymmetricChild(leftTree.right,rightTree.left);
    }

    // 14. 根据前序遍历创建一颗二叉树
    public int i;
    public TreeNode createTree(String str) {
        TreeNode root = null;
        char ch = str.charAt(i);
        if (ch != '#') {
            root = new TreeNode(ch);
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else {
            i++;
        }
        return root;
    }

    // 15. 层序遍历
    public void levelOrder(TreeNode root) {

    }

}
