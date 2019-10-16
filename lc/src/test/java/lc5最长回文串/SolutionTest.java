package lc5最长回文串;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void longestPalindrome() {
        assertEquals("", solution.longestPalindrome(""));
        assertEquals("", solution.longestPalindrome(null));
        assertEquals("a", solution.longestPalindrome("a"));
        assertEquals("b", solution.longestPalindrome("ab"));
        assertEquals("aba", solution.longestPalindrome("aba"));
        assertEquals("abba", solution.longestPalindrome("abba"));
    }
}