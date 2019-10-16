package lc5最长回文串;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        if (length == 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            //获取以i为中心的最长回文串长度
            int len1 = lengthOfPalindrome(s, i, i);
            //获取以i和i+1为中心的最长回文串长度
            int len2 = lengthOfPalindrome(s, i, i + 1);
            //比较哪个长，获取对应的子串
            int len = Math.max(len1, len2);
            //与结果进行比较，并存储最长的子串
            if (len > end - start) {
                //ab i=0 len = 1 start = 0, end = 1
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int lengthOfPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
