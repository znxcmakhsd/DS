import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        String[] courseName = {"TTTK1114","TTTT1713","TTTR1333","TTTT1013","TTTT1022","TTTM2033",};
        int count = 1;

        for (int i = sc.nextInt();i != 0;i = sc.nextInt()) {
            int[][] array = new int[i][6];
            System.out.print("Case #" +  count+ ": Course"+courseName[count-1]);
            System.out.println();

            // 输入
            for (int j = 0;j < i;j++) {
                for (int k = 0;k < 6;k++) {
                    array[j][k] = sc.nextInt();
                }
            }

            // 输出
            for (int j = 0;j < 6;j++) {
                double sum = 0;
                for (int k = 0;k < i;k++) {
                    sum += array[k][j];
                }
                System.out.print("Course "+(j+1)+": ");
                System.out.printf("%.1f",sum/i);
                System.out.println();
            }
            count++;
            System.out.println();
        }

    }
}


