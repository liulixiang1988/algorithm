/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc72编辑距离;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution = new Solution();

  @Test
  void minDistance() {
    assertEquals(3, solution.minDistance("horse", "ros"));
  }
}