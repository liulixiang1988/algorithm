package lc64最小路径和;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minPathSum() {
        int[][] grid = new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        };
        Solution solution = new Solution();
        int res = solution.minPathSum(grid);
        assertEquals(7, res);
    }
}