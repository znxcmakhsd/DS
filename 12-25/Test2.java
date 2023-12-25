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
        // 不相同情况: 
        // 一个根为空 一个根不为空
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        // 走到这说明 两个根都为空 或者 都不为空
        // 如果都为空返回true，都不为空判断值
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        // 走到这说明根相同 接下来判断左右子树是否相同
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

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
        // 不相同情况: 
        // 一个根为空 一个根不为空
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        // 走到这说明 两个根都为空 或者 都不为空
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        // 走到这说明根相同 接下来判断左右子树是否相同
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        // 判断根
        if (isSameTree(root,subRoot)) {
            return true;
        }
        // 判断左子树
        if(isSubtree(root.left,subRoot)) {
            return true;
        }
         // 判断右子树
        if(isSubtree(root.right,subRoot)) {
            return true;
        }
        return false;
 
    }
}

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