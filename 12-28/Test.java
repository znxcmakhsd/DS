1. 二叉树的最近公共祖先
方法1:
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
            return null;
        }
        if (root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) {
            return root;
        }else if(left != null) {
            return left;
        }else {
            return right;
        }

    }
}
方法2:
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
    // 得到root -> node路径上所有节点
    public boolean getPathNode(TreeNode root,TreeNode node,Stack<TreeNode> stack) {
        if (root == null || node == null) {
            return false;
        }
        stack.push(root);
        if (root == node) {
            return true;
        }
        boolean leftFlag = getPathNode(root.left,node,stack);
        if (leftFlag == true) {
            return true;
        }

        boolean rightFlag = getPathNode(root.right,node,stack);
        if (rightFlag == true) {
            return true;
        }
        stack.pop();
        return false;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        getPathNode(root,p,stackP);
        getPathNode(root,q,stackQ);

        int sizeP = stackP.size();
        int sizeQ = stackQ.size();
        if (sizeP > sizeQ) {
            int gap = sizeP - sizeQ;
            while (gap != 0) {
                stackP.pop();
                gap--;
            } 
        }else {
            int gap = sizeQ - sizeP;
            while (gap != 0) {
                stackQ.pop();
                gap--;
            } 
        }

        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode nodeP = stackP.pop();
            TreeNode nodeQ = stackQ.pop(); 
            if (nodeP == nodeQ) {
                return nodeP;
            }
        } 
        return null;
    }
}

package demo;

import java.util.Scanner;

class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

2. 前序遍历创建二叉树
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static int i;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            // 输入
            String str = in.nextLine();
            // 创建二叉树
            TreeNode root = createTree(str);
            // 中序遍历
            inOrder(root);
        }
    }
    public static TreeNode createTree(String str) {
        TreeNode root = null;
        char ch = str.charAt(i);
        i++;
        if (ch != '#') {
            root = new TreeNode(ch);
            root.left = createTree(str);
            root.right = createTree(str);
        }
        return root;

    }
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}