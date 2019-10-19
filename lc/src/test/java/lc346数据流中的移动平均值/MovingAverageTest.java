/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc346数据流中的移动平均值;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MovingAverageTest {

  @Test
  void next() {
    MovingAverage movingAverage = new MovingAverage(3);
    assertEquals(1.0, movingAverage.next(1));
    assertEquals(2.0, movingAverage.next(3));
    assertEquals(3.0, movingAverage.next(5));
    assertEquals(4.0, movingAverage.next(4));
    assertEquals(3.0, movingAverage.next(0));
  }
}