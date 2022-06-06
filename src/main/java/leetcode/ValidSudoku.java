package leetcode;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] digits = new int[10];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                int currentIndex = board[i][j] - '0';
                digits[currentIndex]++;
                if (digits[currentIndex] > 1) return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            int[] digits = new int[10];
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] == '.') continue;
                int currentIndex = board[j][i] - '0';
                digits[currentIndex]++;
                if (digits[currentIndex] > 1) return false;
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                int[] digits = new int[10];
                for (int y = i; y < i + 3; y++) {
                    for (int x = j; x < j + 3; x++) {
                        if (board[y][x] == '.') continue;
                        int currentIndex = board[y][x] - '0';
                        digits[currentIndex]++;
                        if (digits[currentIndex] > 1) return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] invalidBoard = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        ValidSudoku validSudoku = new ValidSudoku();
        assert (validSudoku.isValidSudoku(board));
        assert (!validSudoku.isValidSudoku(invalidBoard));
    }
}
