package DFS和BFS;

public class _329_矩阵中的最长递增路径 {
    int res = 0;
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0},{1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(dfs(matrix, cache, i, j), res);
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int[][] cache, int x, int y) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }

        int max = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length
                    && matrix[x][y] < matrix[nx][ny]) {
                max = Math.max(dfs(matrix, cache, nx, ny), max);
            }
        }

        cache[x][y] = max + 1;
        return cache[x][y];
    }
}
