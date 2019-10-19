/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc346数据流中的移动平均值;

/**
 * TODO Class Description
 *
 * @since 2019-10-19
 */
public class MovingAverage2 {

  int[] queue;
  int head = -1;
  int tail = -1;
  double sum = 0;
  int size;
  int count = 0;

  public MovingAverage2(int size) {
    queue = new int[size];
    this.size = size;
  }

  public double next(int val) {
    if (head == -1) {
      head++;
    }
    if ((tail + 1) % size == head) {
      sum -= queue[head];
      head = (head + 1) % size;
    }
    queue[(++tail) % size] = val;
    sum += val;
    if (++count < size) {
      return sum / count;
    } else {
      count = size;
    }
    return sum / size;
  }
}
