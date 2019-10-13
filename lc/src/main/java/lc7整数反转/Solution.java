/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc7整数反转;

/**
 * lc7整数反转
 *
 * @since 2019-10-13
 */
public class Solution {

  public int reverse(int x) {
    int res = 0;
    int positive = Integer.MAX_VALUE / 10;
    int negative = Integer.MIN_VALUE / 10;
    while (x != 0) {
      int remind = x % 10;
      if (res > positive || (res == positive && remind > 7)) {
        return 0;
      }
      if (res < negative || (res == negative && remind < -8)) {
        return 0;
      }
      res = res * 10 + (x % 10);
      x /= 10;
    }
    return res;
  }
}
