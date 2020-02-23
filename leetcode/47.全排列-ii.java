import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (54.97%)
 * Likes:    173
 * Dislikes: 0
 * Total Accepted:    26.2K
 * Total Submissions: 47.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(list, tempList, nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack( List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<Integer>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            backtrack(list, tempList, nums, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }
}
// @lc code=end

