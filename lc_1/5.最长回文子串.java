/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (28.50%)
 * Likes:    1756
 * Dislikes: 0
 * Total Accepted:    182.4K
 * Total Submissions: 640K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    private int low;
    private int length;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            expandPalindrome(s, i, i);
            expandPalindrome(s, i, i + 1);
        }
        return s.substring(low, low + length);
    }

    private void expandPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (length < right - left - 1) {
            low = left + 1;
            length = right - left - 1;
        }
    }
}
// @lc code=end
