/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc7整数反转;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution = new Solution();

  @Test
  void reverseOutBound() {
    assertEquals(0, solution.reverse(Integer.MAX_VALUE));
    assertEquals(0, solution.reverse(Integer.MAX_VALUE));
    assertEquals(0, solution.reverse(1563847412));
  }

  @Test
  void reverse() {
    assertEquals(123, solution.reverse(321));
    assertEquals(-123, solution.reverse(-321));
  }
}