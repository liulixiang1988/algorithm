/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc200岛屿数量;

import java.util.LinkedList;
import java.util.Queue;

/**
 * lc200岛屿数量-BSF
 *
 * @since 2019-10-20
 */
public class SolutionBSF {

  int row;
  int col;
  int[][] directions = new int[][]{
      new int[]{-1, 0}, new int[]{0, -1}, new int[]{1, 0}, new int[]{0, 1}
  };

  public int numIslands(char[][] grid) {
    // grid有效性检查
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    row = grid.length;
    col = grid[0].length;

    int ans = 0;

    // 广度优先搜索
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1') {
          ans++;
          grid[i][j] = '0';
          bsf(grid, i, j);
        }
      }
    }
    return ans;
  }

  private void bsf(char[][] grid, int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});
    while (!queue.isEmpty()) {
      int[] cor = queue.poll();
      int x2 = cor[0];
      int y2 = cor[1];
      for (int i = 0; i < directions.length; i++) {
        int newX = x2 + directions[i][0];
        int newY = y2 + directions[i][1];
        if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == '1') {
          grid[newX][newY] = '0';
          queue.offer(new int[]{newX, newY});
        }
      }
    }
  }
}
