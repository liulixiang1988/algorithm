/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc200岛屿数量;

/**
 * lc200岛屿数量
 *
 * @since 2019-09-29
 */
public class Solution {

  private boolean[][] isUsed;
  private int rowNum;
  private int colNum;
  private int[][] directions = new int[][]{
      new int[]{-1, 0},
      new int[]{0, -1},
      new int[]{1, 0},
      new int[]{0, 1}
  };

  public int numIslands(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    rowNum = grid.length;
    colNum = grid[0].length;
    isUsed = new boolean[rowNum][colNum];
    for (int i = 0; i < rowNum; i++) {
      isUsed[i] = new boolean[colNum];
    }

    int ans = 0;
    for (int i = 0; i < rowNum; i++) {
      for (int j = 0; j < colNum; j++) {
        if (grid[i][j] != '0' && !isUsed[i][j]) {
          ans++;
        }
        dsf(grid, i, j);
      }
    }
    return ans;
  }

  private void dsf(char[][] grid, int row, int col) {
    if (grid[row][col] == '0') {
      return;
    }

    isUsed[row][col] = true;
    for (int i = 0; i < directions.length; i++) {
      int newRow = row + directions[i][0];
      int newCol = col + directions[i][1];
      if (newRow >= 0 && newRow < rowNum && newCol >= 0 && newCol < colNum
          && !isUsed[newRow][newCol] && grid[newRow][newCol] != '0') {
        dsf(grid, newRow, newCol);
      }
    }
  }
}
