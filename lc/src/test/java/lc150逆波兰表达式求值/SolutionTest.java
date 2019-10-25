/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc150逆波兰表达式求值;

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
  void evalRPN() {
    assertEquals(9, solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
  }

  @Test
  void evalRPN1() {
    assertEquals(6, solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
  }
}