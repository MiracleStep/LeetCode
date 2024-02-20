package 回溯法;

public class _79_单词搜索 {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, vis, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, boolean[][] vis, int index) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                || vis[x][y] || word.charAt(index) != board[x][y]) {
            //越界、遍历过、字符不匹配
            return false;
        }
        if (index == word.length() - 1) {
            //到达最后
            return true;
        }

        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            //直接进行四方向遍历
            if (dfs(board, word, nx, ny, vis, index + 1)) {
                return true;
            }
        }
        vis[x][y] = false;
        return false;
    }
}
