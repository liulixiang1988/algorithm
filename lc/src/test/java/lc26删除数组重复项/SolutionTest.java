/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc26删除数组重复项;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void removeDuplicates() {
    Solution solution = new Solution();
    ;
    assertEquals(2, solution.removeDuplicates(new int[]{1, 1, 2}));
    assertEquals(5, solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    assertEquals(1, solution.removeDuplicates(new int[]{0, 0}));
    assertEquals(2, solution.removeDuplicates(new int[]{1, 2}));
    assertEquals(3, solution.removeDuplicates(new int[]{1, 2, 3}));
    assertEquals(1, solution.removeDuplicates(new int[]{0}));
    assertEquals(0, solution.removeDuplicates(new int[]{}));
    assertEquals(0, solution.removeDuplicates(null));
  }
}