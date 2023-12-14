package MySingleList;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();

        // 测试头插
       /* mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.display();*/

        // 测试尾插
       /* mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.display();*/

        // 测试index位置插入数据
       /* mySingleList.addIndex(0,1);
        mySingleList.addIndex(1,2);
        mySingleList.addIndex(1,3);
        mySingleList.addIndex(3,4);
        mySingleList.display();*/

        /*mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.addLast(5);
        System.out.println(mySingleList.contains(6));*/

        // 测试删除
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.addLast(3);
        mySingleList.addLast(5);
        //mySingleList.remove(3);
        mySingleList.removeAllKey(3);
        mySingleList.display();

    }
}
