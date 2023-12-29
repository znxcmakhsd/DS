1. 从前序与中序遍历序列构造二叉树
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
    public int preIndex ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeChild(preorder,inorder,0,inorder.length-1);

    }
     private TreeNode buildTreeChild(int[] preorder,int[] inorder,int inbegin,int inend) {
        
        if (inbegin > inend) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[this.preIndex]);
        int rootIndex = findIndexRoot(inorder,0,inorder.length,root.val);
        this.preIndex++;

        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);

        return root;
    }
    private int findIndexRoot(int[] inorder,int inbegin, int inend,int key) {
        for (int i = inbegin;i < inend;i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}