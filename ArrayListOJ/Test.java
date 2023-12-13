1. cvte 面试题
// import java.util.ArrayList;
// import java.util.List;

// public class Test {
//     public static List<Character> func2(String str1,String str2) {
//         ArrayList<Character> arrayList = new ArrayList<>();

//         for (int i = 0;i < str1.length();i++) {
//             char ch = str1.charAt(i);
//             int j = 0;
//             for (;j < str2.length();j++) {
//                 if (str2.charAt(j) == ch) {
//                     break;
//                 }
//             }
//             if (j == str2.length()) {
//                 arrayList.add(ch);
//             }
//         }
//         return arrayList;
//     }

//     // 1. cvte 面试题
//     public static List<Character> func1(String str1,String str2) {

//         ArrayList<Character> arrayList = new ArrayList<>();
//         for (int i = 0;i < str1.length();i++) {
//             char ch = str1.charAt(i);
//             if (!str2.contains(ch+"")) {
//                 arrayList.add(ch);
//             }
//         }
//         return arrayList;
//     }

//     public static void main(String[] args) {
//         String str1 = "welcome to cvte";
//         String str2 = "come";
//         System.out.println(func1(str1, str2));
//         System.out.println(func2(str1, str2));
//     }
// }

2. 杨辉三角
// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> retArray = new ArrayList<>();
        
//         // 提前插入第一行
//         List<Integer> firstRow = new ArrayList<>(); 
//         firstRow.add(1);
//         retArray.add(firstRow);

//         for (int i = 1;i < numRows;i++) {            
//             List<Integer> array = new ArrayList<>(); 
//             // 处理头
//             array.add(1);
//             // 处理中间
//             for (int j = 1;j < i;j++) {
//                 List<Integer> lastRow = retArray.get(i-1);// 得到上一行
//                 array.add(lastRow.get(j-1)+lastRow.get(j));                
//             }
//             // 处理尾
//             array.add(1);
//             retArray.add(i,array);
//         }
//         return retArray;
//     }
// }


