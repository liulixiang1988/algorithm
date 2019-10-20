/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc752打开转盘锁;

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
  void openLock() {
    int res = solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
    assertEquals(6, res);
  }

  @Test
  void openLock2() {
    int res = solution.openLock(new String[]{"8888"}, "0009");
    assertEquals(1, res);
  }


  @Test
  void openLock3() {
    int res = solution
        .openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"},
            "8888");
    assertEquals(-1, res);
  }

  @Test
  void openLock4() {
    int res = solution.openLock(new String[]{"0000"}, "8888");
    assertEquals(-1, res);
  }
}