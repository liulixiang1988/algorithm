/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc279完全平方数;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void numSquares() {
    int res = solution.numSquares(12);
    assertEquals(3, res);
  }

  @Test
  void numSquares2() {
    int res = solution.numSquares(13);
    assertEquals(2, res);
  }
}