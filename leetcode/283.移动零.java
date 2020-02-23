/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (59.33%)
 * Likes:    499
 * Dislikes: 0
 * Total Accepted:    109.4K
 * Total Submissions: 183.9K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int slow = 0, fast = 0;
        while( fast < nums.length) {
            // 遇到非0元素放到前面
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        // 后续数据置零
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int slow = 0, fast = 0;
        while( fast < nums.length) {
            // 遇到非0元素进行置换
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}
// @lc code=end

