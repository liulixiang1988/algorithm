/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc43字符串相乘;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void multiply() {
    Solution solution = new Solution();
    assertEquals("0", solution.multiply("0", "0"));
    assertEquals("0", solution.multiply("1000", "0"));
    assertEquals("40", solution.multiply("8", "5"));
    assertEquals("400", solution.multiply("80", "5"));
    assertEquals("2000", solution.multiply("80", "25"));
    assertEquals("50", solution.multiply("2", "25"));
    assertEquals("300", solution.multiply("12", "25"));
    assertEquals("3125", solution.multiply("125", "25"));
  }
}