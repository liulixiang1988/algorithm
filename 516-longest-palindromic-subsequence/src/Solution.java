/**
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * "cbbd"
 * 输出:
 * <p>
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 动态规划，四要素
 * 解题思路：
 * <p>
 * 状态
 * f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
 * <p>
 * 转移方程
 * 如果 s 的第 i 个字符和第 j 个字符相同的话
 * <p>
 * f[i][j] = f[i + 1][j - 1] + 2
 * <p>
 * 如果 s 的第 i 个字符和第 j 个字符不同的话
 * <p>
 * f[i][j] = max(f[i + 1][j], f[i][j - 1])
 * <p>
 * 然后注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
 * <p>
 * 初始化
 * f[i][i] = 1 单个字符的最长回文序列是 1
 * <p>
 * 结果
 * f[0][n - 1]
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] arrays = s.toCharArray();
        int n = arrays.length;
        int[][] f = new int[n][n];

        for(int i = n-1; i >= 0; i--) {
            f[i][i] = 1;
            for(int j= i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = 2 + f[i+1][j-1];
                }
                else {
                    //左边向右移一格，或者，右边向左移一格
                    f[i][j] = Math.max(f[i+1][j], f[i][j-1]);
                }
            }
        }
        return f[0][n-1];
    }
}
