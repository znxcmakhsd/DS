package MySingleList;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();

        // 测试尾插
       /* mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(4);*/
        mySingleList.display();

        // 测试头插
        /*mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.display();*/

        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addIndex(1,4);
        mySingleList.display();


    }
}
