/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc224基本计算器;

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
  void calculate() {
    assertEquals(2, solution.calculate("(1) + (2) - (1)"));
  }

  @Test
  void calculate1() {
    assertEquals(10, solution.calculate("1 + 1 + 2 + 3 + 4 - 1"));
  }

  @Test
  void calculate2() {
    assertEquals(10, solution.calculate("((1+1+2)+3)+4-1"));
  }

  @Test
  void calculate3() {
    assertEquals(3, solution.calculate("((1+1+2)+3)-(4+1)+1"));
  }

  @Test
  void calculate4() {
    assertEquals(1, solution.calculate("(1)"));
  }

  @Test
  void calculate5() {
    assertEquals(112, solution.calculate("(13 + 99)"));
  }

  @Test
  void calculate6() {
    assertEquals(-15, solution.calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
  }
}