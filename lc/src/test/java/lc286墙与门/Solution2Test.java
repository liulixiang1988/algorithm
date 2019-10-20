/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc286墙与门;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class Solution2Test {

  @Test
  void wallsAndGates() {
    Solution2 solution = new Solution2();
    int[][] rooms = new int[][]{
        new int[]{2147483647, -1, 0, 2147483647},
        new int[]{2147483647, 2147483647, 2147483647, -1},
        new int[]{2147483647, -1, 2147483647, -1},
        new int[]{0, -1, 2147483647, 2147483647}};
    solution.wallsAndGates(rooms);
    int[][] expact = new int[][]{
        new int[]{3, -1, 0, 1},
        new int[]{2, 2, 1, -1},
        new int[]{1, -1, 2, -1},
        new int[]{0, -1, 3, 4}};
    assertArrayEquals(expact, rooms);
  }
}