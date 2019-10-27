import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (46.80%)
 * Likes:    177
 * Dislikes: 0
 * Total Accepted:    17.5K
 * Total Submissions: 37.3K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 
 * 要求算法的时间复杂度为 O(n)。
 * 
 * 示例:
 * 
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> unvisited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            unvisited.add(nums[i]);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(unvisited.remove(nums[i])) {
                int sum = 1;
                // 中心拓展
                int val = nums[i];
                while(unvisited.remove(val-1)) {
                    val--;
                }
                sum += nums[i] - val;

                val = nums[i];
                while (unvisited.remove(val + 1)) {
                    val++;
                }
                sum += val - nums[i];
                
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
// @lc code=end

