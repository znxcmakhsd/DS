1. 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return leftHeight > rightHeight
            ? leftHeight+1 : rightHeight+1;

    }
}
2. 判断平衡二叉树
方法1: O(n^2)
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
    public boolean isBalanced(TreeNode root) {
        // 如何判断是否是平衡二叉树
        // 当前根节点左右子树高度差<=1, 左子树平衡 && 右子树平衡
        if (root == null) {
            return true;
        }
        int leftTH = maxDepth(root.left);
        int rightTH = maxDepth(root.right);
        return Math.abs(leftTH - rightTH) <= 1
            && isBalanced(root.left) && isBalanced(root.right);
 
 
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
 
        return leftHeight > rightHeight
            ? leftHeight+1 : rightHeight+1;
 
    }
}

方法2: O(n)
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = maxDepth(root.right);
        if (leftHeight >= 0 && rightHeight >= 0 && 
            Math.abs(leftHeight-rightHeight) <= 1) {
            return Math.max(leftHeight,rightHeight)+1;
        }else {
            return -1;
        }
    }
 
    public boolean isBalanced(TreeNode root) {
        // 计算高度的同时判断是否平衡
        if (root == null) {
            return true;
        }
        return maxDepth(root) != -1;
    }
    
}
3. 判断对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        // 一个为空 一个不为空 ———— 不对称
        if (leftTree == null && rightTree != null) {
            return false;
        }
        if (leftTree != null && rightTree == null) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }
        // 走到这说明根对称, 然后接下来判断 
        // 左子树的左——右子树的右 && 左子树的右——右子树的左 是否对称
        return isSymmetricChild(leftTree.left,rightTree.right) 
            && isSymmetricChild(leftTree.right,rightTree.left);
 
 
    }
}
4. 前序遍历创建二叉树
import java.util.Scanner;
 
class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;
 
    public TreeNode(char val) {
        this.val = val;
    }
}
 
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static int i;
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
 
            // 根据输入的前序遍历创建树
            TreeNode root = createTree(str);
 
            // 中序遍历
            inOrder(root);
 
        }
    }
    public static TreeNode createTree(String str) {
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else {
            i++;
        }
        return root;
    }
    public static void inOrder(TreeNode root) {
        // 左根右
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}
5. 二叉树的层序遍历
    public void levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val+" ");

            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public List<List<Character>> levelOrder(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Character> array = new ArrayList<>();
            int size = queue.size();

            while (size != 0) {
                TreeNode cur = queue.poll();
                array.add(cur.val);
                size--;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ret.add(array);
        }
        return ret;
    }