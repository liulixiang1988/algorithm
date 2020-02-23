import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (64.12%)
 * Likes:    175
 * Dislikes: 0
 * Total Accepted:    15K
 * Total Submissions: 23.4K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        backtrack(list, tempList, s, 0);
        return list;
    }

    private void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tempList.add(s.substring(start, i+1));
                backtrack(list, tempList, s, i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
// @lc code=end

