/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc286墙与门;

import java.util.LinkedList;
import java.util.Queue;

/**
 * lc286墙与门
 *
 * @since 2019-10-20
 */
public class Solution2 {

  private int[][] directions = new int[][]{
      new int[]{-1, 0}, new int[]{0, -1}, new int[]{1, 0}, new int[]{0, 1}
  };
  private int row;
  private int col;

  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
      return;
    }
    row = rooms.length;
    col = rooms[0].length;
    Queue<int[]> queue = getAllGates(rooms);
    //层序遍历，BSF
    bsf(rooms, queue);
  }

  private Queue<int[]> getAllGates(int[][] rooms) {
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (rooms[i][j] == 0) {
          queue.add(new int[]{i, j});
        }
      }
    }
    return queue;
  }

  private void bsf(int[][] rooms, Queue<int[]> queue) {
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      step++;
      for (int i = 0; i < size; i++) {
        int[] cor = queue.poll();
        int x = cor[0];
        int y = cor[1];
        for (int j = 0; j < directions.length; j++) {
          int newX = x + directions[j][0];
          int newY = y + directions[j][1];
          //范围判断与有效判断
          if (newX >= 0 && newX < row && newY >= 0 && newY < col
              && rooms[newX][newY] == Integer.MAX_VALUE) {
            rooms[newX][newY] = step;
            queue.offer(new int[]{newX, newY});
          }
        }
      }
    }
  }
}
