import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Character> arrayList = new ArrayList<>();
        String str1 = "welcome to cvte";
        String str2 = "come";
        for (int i = 0;i < str1.length();i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch+"")) {
                arrayList.add(ch);
            }
        }
        System.out.println(arrayList);
    }

    public static void main1(String[] args) {
        ArrayList<Character> arrayList = new ArrayList<>();
        String str1 = "welcome to cvte";
        String str2 = "come";

        for (int i = 0;i < str1.length();i++) {
            char ch = str1.charAt(i);
            int j = 0;
            for (;j < str2.length();j++) {
                if (ch == str2.charAt(j)) {
                    break;
                }
            }
            if (j == str2.length()) {
                arrayList.add(ch);
            }
        }
        System.out.println(arrayList);

    }
}