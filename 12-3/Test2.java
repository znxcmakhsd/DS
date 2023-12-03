// ArrayList 解 杨辉三角
https://leetcode.cn/problems/pascals-triangle/description/
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<Integer> firstArr = new ArrayList();
        firstArr.add(1);
        List<List<Integer>> list = new ArrayList();
        list.add(firstArr);

        for(int i = 1;i < numRows;i++) {
            List<Integer> array = new ArrayList<>();
            array.add(1);
            for(int j = 1;j < i;j++) {
                // 1. 找到上一列的 [i-1,j-1] [i-1,j]
                List<Integer> prevRow = list.get(i-1);
                int sum = prevRow.get(j-1) + prevRow.get(j);
                array.add(sum);
            } 
            array.add(1);
            list.add(array);
        }
        return list;
    }
}