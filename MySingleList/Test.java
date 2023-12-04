package MySingleList;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();

        // 测试尾插
       /* mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(4);*/
        //mySingleList.display();

        // 测试头插
        /*mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.display();*/

        /*mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addIndex(1,4);*/

        // 测试  // index任意位置插入
       /* mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        // 测试头插
        mySingleList.addIndex(0,4);
        mySingleList.display();
        // 测试中间插入
        mySingleList.addIndex(2,5);
        mySingleList.display();
        // 测试尾插
        mySingleList.addIndex(5,6);
        mySingleList.display();*/

        // 测试删除
        mySingleList.addLast(2);
        mySingleList.addLast(2);
        mySingleList.addLast(2);
        mySingleList.addLast(2);
        mySingleList.addLast(2);
        //mySingleList.remove(1);
        mySingleList.display();
        mySingleList.removeAllKey(2);
        mySingleList.removeAllKey(1);
        mySingleList.display();


    }
}
