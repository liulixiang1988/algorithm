/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc8atoi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void myAtoi() {
    Solution solution = new Solution();
    assertEquals(42, solution.myAtoi("42"));
    assertEquals(-42, solution.myAtoi("-42"));
    assertEquals(42, solution.myAtoi("+42"));
    assertEquals(42, solution.myAtoi("+42 dd"));
    assertEquals(0, solution.myAtoi("+d42 dd"));
    assertEquals(0, solution.myAtoi("d42 dd"));
    assertEquals(Integer.MAX_VALUE, solution.myAtoi("42123133888188281881118 dd"));
    assertEquals(Integer.MIN_VALUE, solution.myAtoi("-311212123133888188281881118 dd"));
  }
}