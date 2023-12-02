package ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(0,3);

        arrayList.display();

        arrayList.remove(3);
        arrayList.display();

    }
}
