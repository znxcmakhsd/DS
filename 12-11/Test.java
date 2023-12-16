1. 相同的树
https://leetcode.cn/problems/same-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果一个为空 一个不为空 ——》 false
        if (p == null && q != null || p != null && q==null) {
            return false;
        }
        // 走到这里表示 都为空 / 都不为空
        // 如果为空 ——》 两颗树都是空树 ——》 true
        if (p == null && q == null) {
            return true;
        }
        // 都不为空 判断值
        if (p.val != q.val) {
            return false;
        }
        // 如果相同 则去判断左子树和右子树 是否相等
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
2. 另一棵树的子树
https://leetcode.cn/problems/subtree-of-another-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果一个为空 一个不为空 ——》 false
        if (p == null && q != null || p != null && q==null) {
            return false;
        }
        // 走到这里表示 都为空 / 都不为空
        // 如果为空 ——》 两颗树都是空树 ——》 true
        if (p == null && q == null) {
            return true;
        }
        // 都不为空 判断值
        if (p.val != q.val) {
            return false;
        }
        // 如果相同 则去判断左子树和右子树 是否相等
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        // 从根节点开始判断 
        if (isSameTree(root,subRoot)) {
            return true;
        }
        // 如果没有在 去左子树中找
        if (isSubtree(root.left,subRoot)) {
            return true;
        }
        if (isSubtree(root.right,subRoot)) {
            return true;
        }
        return false;

    }
}
3. 226. 翻转二叉树
https://leetcode.cn/problems/invert-binary-tree/description/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}