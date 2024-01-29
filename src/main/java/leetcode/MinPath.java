package leetcode;

public class MinPath {

    public static int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] minSumGrid = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int currSum = Integer.MAX_VALUE;

                if (i - 1 >= 0) {
                    currSum = Math.min(currSum, minSumGrid[i - 1][j] + grid[i][j]);
                }

                if (j - 1 >= 0) {
                    currSum = Math.min(currSum, minSumGrid[i][j - 1] + grid[i][j]);
                }

                if (currSum == Integer.MAX_VALUE) {
                    minSumGrid[i][j] = grid[i][j];
                    continue;
                }
                minSumGrid[i][j] = currSum;
            }
        }
        return minSumGrid[height - 1][width - 1];
    }

    public static void main(String[] args) {
        int[][] ints = {
                {1, 2, 9},
                {9, 1, 6},
                {5, 8, 1}
        };
        System.out.println(minPathSum(ints));
    }
}
