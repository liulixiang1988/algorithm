/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc53最大子序和;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void maxSubArray() {
    Solution solution = new Solution();
    assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}