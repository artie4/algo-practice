package leetcode.algo_1_path;

import java.util.Arrays;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length < 1) return -1;

        // search for rotten
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rot(grid, i, j, 2);
                }
            }
        }

        int maxTicks = 2;
        for(int[] row: grid) {
            for (int cell: row) {
                if (cell == 1) return -1;
                maxTicks = Math.max(cell, maxTicks);
            }
        }
        return maxTicks - 2;
    }

    private void rot(int[][] grid, int y, int x, int ticks) {
        // check for bounds
        if (y < 0 || x < 0 || y >= grid.length || x >= grid[0].length) return;

        int currentBucket = grid[y][x];

        // check if empty
        if (currentBucket == 0) return;

        // check for already rotten
        if (1 < currentBucket && currentBucket < ticks) return;

        // rot current
        grid[y][x] = ticks;

        // rot adjacent
        rot(grid, y - 1, x, ticks + 1);
        rot(grid, y + 1, x, ticks + 1);
        rot(grid, y, x - 1, ticks + 1);
        rot(grid, y, x + 1, ticks + 1);
    }

    private void printMatrix(int[][] matrix) {
        for(int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {2,0,0,0,1},
                {1,1,1,0,1},
                {1,0,1,0,1},
                {1,0,1,0,1},
                {1,0,1,1,1}
        };

        int[][] grid2 = {
                {1,1,1,1,1},
                {1,0,1,0,1},
                {1,0,2,0,1},
                {1,0,1,0,1},
                {1,1,1,1,1}
        };

        RottingOranges rottingOranges = new RottingOranges();
        assert(rottingOranges.orangesRotting(grid1) == 12);
        assert(rottingOranges.orangesRotting(grid2) == 6);
    }
}
