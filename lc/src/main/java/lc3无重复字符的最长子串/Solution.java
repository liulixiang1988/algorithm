/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc3无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * lc3无重复字符的最长子串
 *
 * @since 2019-10-13
 */
public class Solution {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int left = 0;
    int right = 0;
    int length = s.length();
    Set<Character> charSet = new HashSet<>();
    int result = 0;
    while (right < length) {
      while (charSet.contains(s.charAt(right))) {
        charSet.remove(s.charAt(left++));
      }
      charSet.add(s.charAt(right));
      result = Math.max(result, right - left + 1);
      right++;
    }
    return result;
  }
}
