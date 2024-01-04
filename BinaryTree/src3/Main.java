/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = sc.nextInt();i != 0;i = sc.nextInt()) {
            int[][] array = new int[i][i];
            //String[] courseName = {"TTTK1114","TTTR1333","TTTT1713","TTTT1013","TTTT1022","TTTM2033",};
            // 输入
            for (int j = 0;j < i;j++) {
                for (int k = 0;k < i;k++) {
                    array[j][k] = sc.nextInt();
                }
            }
            // 输出
            for (int j = 0;j < i;j++) {
                //int sum = 0;
                for (int k = 0;k < i;k++) {
                    System.out.print(array[i][k] + " ");
                }
               */
/* System.out.print("Case #" + j + ": Course"+courseName[j]);
                System.out.print("Cource "+j+": ");
                System.out.printf("%.1f",(double)sum/i);*//*

            }
            System.out.println();
        }

    }
}

*/

/*
import java.util.*;

//Your program will be evaluated by this DriverMain class and several test cases.

public class DriverMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        ProblemSolution problemSolution = new ProblemSolution();
        System.out.print(problemSolution.solution(N));
    }
}*/

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class TreeNode {
    public TreeNode left;
    public char val;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
           String str = in.nextLine();

           TreeNode root = createTree(str);

           inOrder(root);

        }
    }
    // 根据前序遍历创建一颗二叉树
    public static int i;
    public static TreeNode createTree(String str) {
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
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
}
