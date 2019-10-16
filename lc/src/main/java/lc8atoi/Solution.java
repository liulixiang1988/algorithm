/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc8atoi;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @since 2019-10-16
 */
public class Solution {

  public int myAtoi(String str) {
    if (str == null || str.trim().length() == 0) {
      return 0;
    }
    str = str.trim();
    int res = 0;
    char[] letters = str.toCharArray();
    if (letters[0] != '+' && letters[0] != '-' && letters[0] < '0' || letters[0] > '9') {
      return res;
    }
    boolean isPositive = true;
    if (letters[0] == '+') {
      isPositive = true;
    } else if (letters[0] == '-') {
      isPositive = false;
    } else {
      res = letters[0] - '0';
    }
    int positive = Integer.MAX_VALUE / 10;
    int negative = Integer.MIN_VALUE / 10;
    for (int i = 1; i < letters.length; i++) {
      if (letters[i] < '0' || letters[i] > '9') {
        break;
      }
      if (isPositive && (res > positive || (res == positive && letters[i] > 7))) {
        return Integer.MAX_VALUE;
      }
      if (!isPositive && (-res < negative || (-res == negative && letters[i] > 8))) {
        return Integer.MIN_VALUE;
      }
      res = res * 10 + letters[i] - '0';
    }
    return isPositive ? res : -res;
  }
}
