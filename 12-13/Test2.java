import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] array = str.split(" ");
        int left = 0;
        int right = array.length;
        while (left < right) {
            String tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < array.length;i++) {
            stringBuilder.append(array[i]+" ");
        }
        System.out.println(stringBuilder.toString());
    }
    public static String[] sort(String str) {
        String[] array = str.split(" ");
        for (int i = 0;i < array.length;i++) {
            for (int j = 0;j < array.length-1-i;j++) {
                if (array[j].charAt(0) < array[j+1].charAt(0)) {
                    String tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] ret = sort(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < ret.length;i++) {
            stringBuilder.append(ret[i]+" ");
        }
        System.out.println(stringBuilder.toString());
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] count = new int[26];
        for (int i = 0;i < str.length();i++) {
            char ch = str.charAt(i);
            count[ch-97]++;
        }

        // 找到出现最多字符下标
        int max = 0;
        int index = 0;
        for (int i = 0;i < count.length;i++) {
            if (max < count[i]) {
                max = count[i];
                index = i;
            }
        }
        char ch = (char) (index+97);
        System.out.println(ch);
        
    }
}