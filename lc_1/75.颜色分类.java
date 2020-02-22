/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 *
 * https://leetcode-cn.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (54.48%)
 * Likes:    334
 * Dislikes: 0
 * Total Accepted:    58.9K
 * Total Submissions: 108K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 
 * 示例:
 * 
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 
 * 进阶：
 * 
 * 
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * 
 * 
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        for (int curr = 0; curr <= right; curr++) {
            while (nums[curr] == 2 & curr < right) {
                swap(nums, curr, right);
                right--;
            }
            while (nums[curr] == 0 && left < curr) {
                swap(nums, curr, left);
                left++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int curr = 0;
        while (curr <= right) {
            if (nums[curr] == 2) {
                swap(nums, curr, right);
                right--;
            } else if (nums[curr] == 0) {
                swap(nums, curr, left);
                left++;
                curr++;
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
// @lc code=end
