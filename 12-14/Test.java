1. 移除元素
https://leetcode.cn/problems/remove-element/description/
class Solution {
    public int removeElement(int[] nums, int val) {
        int prev = 0;
        int cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != val) {
                nums[prev] = nums[cur];
                prev++;
                cur++;
            }else {
                cur++;
            }
        }
        return prev;
    }
}
2. 删除有序数组中的重复项
https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 1;
        int prev = 0;
        while (cur < nums.length) {
            if (nums[cur] == nums[prev]) {
                cur++;
            }else {
                prev++;
                nums[prev] = nums[cur];
                cur++;
            }
        }
        return prev+1;
    }
}
// 3. 88. 合并两个有序数组
https://leetcode.cn/problems/merge-sorted-array/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m+n-1;
        while (j >= 0 && i >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            }else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}


