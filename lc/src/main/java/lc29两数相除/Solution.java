/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc29两数相除;

/**
 * lc29两数相除
 *
 * @since 2019-10-06
 */
public class Solution {

  public int divide(int dividend, int divisor) {
    if (dividend == 0) {
      return 0;
    }
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    boolean negative = (dividend ^ divisor) < 0;
    int t = Math.abs(dividend);
    int d = Math.abs(divisor);
    int result = 0;
    for (int i = 31; i >= 0; i--) {
      if ((t >> i) >= d) {
        result += 1 << i;
        t -= d << i;
      }
    }
    return negative ? -result : result;
  }
}
