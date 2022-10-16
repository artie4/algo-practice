package leetcode;

public class NumIslands {

    public static void main(String[] args) {

        char[][] threeIslandsGrid = new char[][] {
                {'1', '0', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };

        char[][] twoIslandsGrid = new char[][] {
                {'1', '0', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
        };

        assert(numIslands(threeIslandsGrid) == 3);
        assert(numIslands(twoIslandsGrid) == 2);
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(i, j, grid);
                    result++;
                }
            }
        }
        return result;
    }

    private static void helper(int i, int j, char[][] grid) {
        grid[i][j] = '2';
        int up = i + 1;
        if (up < grid.length && grid[up][j] == '1') {
            helper(up, j, grid);
        }
        int down = i - 1;
        if (down >= 0 && grid[down][j] == '1') {
            helper(down, j, grid);
        }
        int left = j - 1;
        if (left >= 0 && grid[i][left] == '1') {
            helper(i, left, grid);
        }
        int right = j + 1;
        if (right < grid[i].length && grid[i][right] == '1') {
            helper(i, right, grid);
        }
    }
}
