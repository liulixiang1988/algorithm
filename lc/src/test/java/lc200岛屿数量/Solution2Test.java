/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc200岛屿数量;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Solution2Test {


  Solution2 solution;

  @BeforeEach
  void setUp() {
    solution = new Solution2();
  }

  @Test
  void numIs1() {
    String s = "11110\n"
        + "11010\n"
        + "11000\n"
        + "00000";
    String[] a = s.split("\n");
    char[][] grid = new char[a.length][];
    for (int i = 0; i < a.length; i++) {
      grid[i] = a[i].toCharArray();
    }
    int res = solution.numIslands(grid);
    assertEquals(1, res);
  }

  @Test
  void numIs2() {
    String s = "11000\n"
        + "11000\n"
        + "00100\n"
        + "00011";
    String[] a = s.split("\n");
    char[][] grid = new char[a.length][];
    for (int i = 0; i < a.length; i++) {
      grid[i] = a[i].toCharArray();
    }
    int res = solution.numIslands(grid);
    assertEquals(3, res);
  }

  @Test
  void numIs3() {
    String s = "111\n"
        + "010\n"
        + "111";
    String[] a = s.split("\n");
    char[][] grid = new char[a.length][];
    for (int i = 0; i < a.length; i++) {
      grid[i] = a[i].toCharArray();
    }
    int res = solution.numIslands(grid);
    assertEquals(1, res);
  }
}