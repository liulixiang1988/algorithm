/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp =nums[i]+nums[left]+nums[right];
                if ( Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }
                if (temp > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

