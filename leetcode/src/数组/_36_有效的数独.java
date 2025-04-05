package 数组;

public class _36_有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][][] mat = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (Character.isDigit(c)) {
                    int cur = c - '0' - 1;
                    if (rows[i][cur]) return false;
                    if (cols[j][cur]) return false;
                    if (mat[i / 3][j / 3][cur]) return false;
                    rows[i][cur] = true;
                    cols[j][cur] = true;
                    mat[i / 3][j / 3][cur] = true;
                }
            }
        }
        return true;
    }
}
