import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (67.11%)
 * Likes:    420
 * Dislikes: 0
 * Total Accepted:    41.8K
 * Total Submissions: 62.2K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return list;
        }
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, 0, target);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int index, int remain) {
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (remain < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(list, tempList, candidates, i, remain - candidates[i]);
            tempList.remove(tempList.size() - 1);
        }
    }
}
// @lc code=end

