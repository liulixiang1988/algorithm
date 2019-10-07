package lc64最小路径和;

public class Solution {
    public int minPathSum(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int[][] dp = new int[rowNum + 1][colNum + 1];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (i == 0) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + grid[i][j];
                } else if (j == 0) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + grid[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
                }
            }
        }
        return dp[rowNum][colNum];
    }
}
