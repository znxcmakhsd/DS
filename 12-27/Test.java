/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == q || root == p) {
            return root;
        }
        TreeNode left =  lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // 情况1: 根的两边不为空 说明这个根就是公共祖先
        if (left != null && right != null) {
            return root;

        }else if(left != null) {
            // 右边为空 左边不为空
            return left;
        }else {
            return right;
        }

    }
}