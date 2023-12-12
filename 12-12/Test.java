import jdk.internal.org.objectweb.asm.tree.LineNumberNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);

        // 第一种遍历:
        System.out.println(arrayList1);

        // 第二种遍历: for
        for (int i = 0;i < arrayList1.size();i++) {
            System.out.print(arrayList1.get(i) + " ");
        }
        System.out.println();

        // 第三种遍历: for-each
        for (Integer x:arrayList1) {
            System.out.print(x+" ");
        }
        System.out.println();

        // 第4种遍历: 迭代器 Iterator
        Iterator<Integer> it = arrayList1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();

        // 第5种遍历: 迭代器 ListIterator
        ListIterator<Integer> it2 = arrayList1.listIterator();
        while (it2.hasNext()) {
            System.out.print(it2.next()+" ");
        }
        System.out.println();

        // 第6种遍历: 迭代器 ListIterator 从后->前
        ListIterator<Integer> it3 = arrayList1.listIterator(arrayList1.size());
        while (it3.hasPrevious()) {
            System.out.print(it3.previous()+" ");
        }
        System.out.println();
    }
}