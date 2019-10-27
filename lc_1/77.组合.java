import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (70.89%)
 * Likes:    173
 * Dislikes: 0
 * Total Accepted:    22.7K
 * Total Submissions: 32.1K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(list, tempList, n, k, 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int max, int remain, int start) {
        if (remain == 0) {
            list.add(new ArrayList<Integer>(tempList));
            return;
        }
        for (int i = start; i <= max; i++) {
            tempList.add(i);
            backtrack(list, tempList, max, remain - 1, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
// @lc code=end

