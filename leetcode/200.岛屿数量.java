import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (46.96%)
 * Likes:    374
 * Dislikes: 0
 * Total Accepted:    56.9K
 * Total Submissions: 120.9K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
class Solution {
    private int rows;
    private int cols;
    private int[][] directions = new int[][] {
        new int[]{0, -1}, new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}
    };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;

        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(char[][] grid, int row, int col) {
        // 步骤1-加入队列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        // 步骤2-判断队列是否为空
        while (!queue.isEmpty()) {
            int[] cor = queue.poll();
            int x = cor[0];
            int y = cor[1];
            // 遍历后续各种可能
            for (int i = 0; i < directions.length; i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == '1') {
                    grid[newX][newY] = '0';
                    // 加入到各队列
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
// @lc code=end

