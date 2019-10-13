/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc33搜索旋转排序数组;

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
  void search() {
    assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    assertEquals(3, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
    assertEquals(2, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
    assertEquals(5, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
    assertEquals(6, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
    assertEquals(0, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
    assertEquals(-1, solution.search(new int[]{}, 0));
    assertEquals(-1, solution.search(new int[]{1}, 0));
    assertEquals(0, solution.search(new int[]{0}, 0));
    assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    assertEquals(-1, solution.search(new int[]{1, 2, 3}, 4));
    assertEquals(0, solution.search(new int[]{1, 2, 3}, 1));
    assertEquals(1, solution.search(new int[]{8, 9, 2, 3, 4}, 9));
  }
}