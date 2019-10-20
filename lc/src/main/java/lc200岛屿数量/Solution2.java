/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc200岛屿数量;

/**
 * lc200岛屿数量-DSF二刷
 *
 * @since 2019-10-20
 */
public class Solution2 {

  int row;
  int col;
  boolean[][] visited;
  int[][] directions = new int[][]{
      new int[]{-1, 0}, new int[]{0, -1}, new int[]{1, 0}, new int[]{0, 1}
  };

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    row = grid.length;
    col = grid[0].length;
    visited = new boolean[row][col];

    int ans = 0;
    // 遍历方格中1的数量，使用DSF
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          ans++;
          dsf(grid, i, j);
        }
      }
    }
    return ans;
  }

  private void dsf(char[][] grid, int x, int y) {
    if (grid[x][y] == '0') {
      return;
    }
    visited[x][y] = true;
    for (int i = 0; i < directions.length; i++) {
      int newX = x + directions[i][0];
      int newY = y + directions[i][1];
      // 判断是否在网络内，且未访问过
      if (newX >= 0 && newX < row && newY >= 0 && newY < col
          && grid[newX][newY] == '1' && !visited[newX][newY]) {
        dsf(grid, newX, newY);
      }
    }
  }
}
