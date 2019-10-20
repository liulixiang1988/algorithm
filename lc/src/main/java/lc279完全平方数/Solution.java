/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc279完全平方数;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * lc279完全平方数
 *
 * @since 2019-10-20
 */
public class Solution {

  public int numSquares(int n) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(n);
    Set<Integer> visited = new HashSet<>();
    visited.add(n);
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      step++;
      for (int j = 0; j < size; j++) {
        int current = queue.poll();
        int max = (int) Math.sqrt(current);
        for (int i = 1; i <= max; i++) {
          int left = current - i * i;
          if (left == 0) {
            return step;
          } else if (left > 0 && !visited.contains(left)) {
            queue.offer(left);
            visited.add(left);
          }
        }
      }
    }
    return -1;
  }
}
