package MyLinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
       /* myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);*/
        /*myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addIndex(2,4);
        myLinkedList.display();
        System.out.println(myLinkedList.last.value);*/

        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.removeAllKey(1);

        myLinkedList.display();

    }
}
