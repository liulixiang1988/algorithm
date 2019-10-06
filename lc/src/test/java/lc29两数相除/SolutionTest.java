/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc29两数相除;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void divide() {
    Solution solution = new Solution();
    assertEquals(50, solution.divide(100, 2));
    assertEquals(33, solution.divide(100, 3));
    assertEquals(33, solution.divide(101, 3));
  }
}