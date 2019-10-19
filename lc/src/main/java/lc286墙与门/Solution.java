/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc286墙与门;

import java.util.LinkedList;
import java.util.Queue;

/**
 * lc286墙与门
 *
 * @since 2019-10-19
 */
public class Solution {

  private static class Cor {

    int x;
    int y;

    Cor(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  int row;
  int col;

  int[][] directions = new int[][]{
      new int[]{-1, 0},
      new int[]{0, -1},
      new int[]{1, 0},
      new int[]{0, 1}
  };

  public void wallsAndGates(int[][] rooms) {
    if (rooms.length == 0 || rooms[0].length == 0) {
      return;
    }
    row = rooms.length;
    col = rooms[0].length;
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] != 0) {
          continue;
        }
        bsf(rooms, i, j);
      }
    }
  }

  private void bsf(int[][] rooms, int x, int y) {
    Queue<Cor> queue = new LinkedList<>();
    queue.add(new Cor(x, y));
    int step = 0;
    while (!queue.isEmpty()) {

      step++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Cor cor = queue.poll();
        for (int[] direction : directions) {
          int newX = cor.x + direction[0];
          int newY = cor.y + direction[1];
          if (newX >= 0 && newX < row && newY >= 0 && newY < col && rooms[newX][newY] != 0
              && rooms[newX][newY] != -1 && rooms[newX][newY] > step) {
            rooms[newX][newY] = step;
            queue.offer(new Cor(newX, newY));
          }
        }
      }
    }
  }
}
