/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc346数据流中的移动平均值;

import java.util.LinkedList;
import java.util.Queue;

/**
 * lc346数据流中的移动平均值
 *
 * @since 2019-10-19
 */
public class MovingAverage {

  private Queue<Integer> queue;
  private double size;
  private double sum = 0;

  /**
   * Initialize your data structure here.
   */
  public MovingAverage(int size) {
    queue = new LinkedList<>();
    this.size = size;
  }

  public double next(int val) {
    queue.offer(val);
    if (queue.size() > size) {
      sum -= queue.poll();
    }
    sum = sum + val;
    return sum / Math.min(queue.size(), size);
  }
}
