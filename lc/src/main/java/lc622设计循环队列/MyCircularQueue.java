/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc622设计循环队列;

/**
 * lc622设计循环队列
 *
 * @since 2019-10-19
 */
public class MyCircularQueue {

  int[] data;
  int head;
  int tail;
  int capacity;


  /**
   * Initialize your data structure here. Set the size of the queue to be k.
   */
  public MyCircularQueue(int k) {
    data = new int[k];
    head = tail = -1;
    capacity = k;
  }

  /**
   * Insert an element into the circular queue. Return true if the operation is successful.
   */
  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    if (head == -1) {
      head++;
    }
    tail = (1 + tail) % capacity;
    data[tail] = value;
    return true;
  }

  /**
   * Delete an element from the circular queue. Return true if the operation is successful.
   */
  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    if (head == tail) {
      head = -1;
      tail = -1;
    } else {
      head = (head + 1) % capacity;
    }

    return true;
  }

  /**
   * Get the front item from the queue.
   */
  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return data[head];
  }

  /**
   * Get the last item from the queue.
   */
  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    return data[tail];
  }

  /**
   * Checks whether the circular queue is empty or not.
   */
  public boolean isEmpty() {
    return head == tail && head == -1;
  }

  /**
   * Checks whether the circular queue is full or not.
   */
  public boolean isFull() {
    return (tail + 1) % capacity == head;
  }
}
/**
 * Your MyCircularQueue object will be instantiated and called as such: MyCircularQueue obj = new
 * MyCircularQueue(k); boolean param_1 = obj.enQueue(value); boolean param_2 = obj.deQueue(); int
 * param_3 = obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty(); boolean param_6
 * = obj.isFull();
 */
