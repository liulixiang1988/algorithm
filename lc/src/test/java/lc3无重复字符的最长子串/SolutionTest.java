/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc3无重复字符的最长子串;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution = new Solution();

  @Test
  void lengthOfLongestSubstringIs3() {
    assertEquals(0, solution.lengthOfLongestSubstring(""));
    assertEquals(1, solution.lengthOfLongestSubstring("a"));
    assertEquals(1, solution.lengthOfLongestSubstring("aa"));
    assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
    assertEquals(3, solution.lengthOfLongestSubstring("abbabcbb"));
  }
}