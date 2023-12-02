import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Character> func(String str1,String str2) {
        ArrayList arrayList = new ArrayList();
        int index = 0;
        for (int i = 0;i < str1.length();i++) {
            int j = 0;
            for (;j < str2.length();j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    break;
                }
            }
            if (j == str2.length()) {
                arrayList.add(index,str1.charAt(i));
                index++;
            }
        }
        return arrayList;
    }
    public static void main(String[] args) {


        String str1 = "welcome to cvte";
        String str2 = "come";
        System.out.println(func(str1,str2));


    }
}