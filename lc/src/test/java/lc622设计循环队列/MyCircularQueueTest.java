/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc622设计循环队列;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCircularQueueTest {

  MyCircularQueue queue;

  @BeforeEach
  void setUp() {
    queue = new MyCircularQueue(3);
  }

  @Test
  void enQueue() {
    assertTrue(queue.enQueue(1));
    assertTrue(queue.enQueue(2));
    assertTrue(queue.enQueue(3));
    assertFalse(queue.enQueue(4));
  }

  @Test
  void deQueue() {
    assertTrue(queue.enQueue(1));
    assertTrue(queue.enQueue(2));
    assertTrue(queue.enQueue(3));
    assertFalse(queue.enQueue(4));
    assertTrue(queue.deQueue());
    assertTrue(queue.deQueue());
    assertTrue(queue.deQueue());
    assertFalse(queue.deQueue());
    assertFalse(queue.deQueue());
  }

  @Test
  void front() {
    queue.enQueue(1);
    assertEquals(1, queue.Front());
    queue.enQueue(2);
    assertEquals(1, queue.Front());
    queue.enQueue(3);
    assertEquals(1, queue.Front());
    queue.enQueue(4);
    assertEquals(1, queue.Front());
    assertTrue(queue.deQueue());
    assertEquals(2, queue.Front());
    assertTrue(queue.deQueue());
    assertEquals(3, queue.Front());
    assertTrue(queue.deQueue());
    assertEquals(-1, queue.Front());
    assertFalse(queue.deQueue());
    assertEquals(-1, queue.Front());
  }

  @Test
  void rear() {
    queue.enQueue(1);
    assertEquals(1, queue.Rear());
    queue.enQueue(2);
    assertEquals(2, queue.Rear());
    queue.enQueue(3);
    assertEquals(3, queue.Rear());
    queue.enQueue(4);
    assertEquals(3, queue.Rear());
    assertTrue(queue.deQueue());
    assertEquals(3, queue.Rear());
    assertTrue(queue.deQueue());
    assertEquals(3, queue.Rear());
    assertTrue(queue.deQueue());
    assertEquals(-1, queue.Rear());
    assertFalse(queue.deQueue());
    assertEquals(-1, queue.Rear());
  }

  @Test
  void isEmpty() {
    assertTrue(queue.isEmpty());
    assertTrue(queue.enQueue(1));
    assertFalse(queue.isEmpty());
    assertTrue(queue.enQueue(2));
    assertTrue(queue.enQueue(3));
    assertFalse(queue.enQueue(4));
    assertFalse(queue.isEmpty());
    assertTrue(queue.deQueue());
    assertFalse(queue.isEmpty());
    assertTrue(queue.deQueue());
    assertFalse(queue.isEmpty());
    assertTrue(queue.deQueue());
    assertTrue(queue.isEmpty());
    assertFalse(queue.deQueue());
    assertTrue(queue.isEmpty());
  }

  @Test
  void isFull() {
    assertFalse(queue.isFull());
    assertTrue(queue.enQueue(1));
    assertFalse(queue.isFull());
    assertTrue(queue.enQueue(2));
    assertTrue(queue.enQueue(3));
    assertTrue(queue.isFull());
    assertFalse(queue.enQueue(4));
    assertTrue(queue.isFull());
    assertTrue(queue.deQueue());
    assertFalse(queue.isFull());
    assertTrue(queue.deQueue());
    assertFalse(queue.isFull());
    assertTrue(queue.deQueue());
    assertFalse(queue.isFull());
    assertFalse(queue.deQueue());
    assertFalse(queue.isFull());
  }
}