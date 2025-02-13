import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int res = 0;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] g = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        boolean[][] leftTop = new boolean[n][m];
        boolean[][] rightBottom = new boolean[n][m];

        // 从左上边界出发进行DFS
        for (int j = 0; j < m; j++) {
            dfs(g, leftTop, 0, j, Integer.MIN_VALUE);
            dfs(g, rightBottom, n - 1, j, Integer.MIN_VALUE);
        }

        // 从右下边界出发进行DFS
        for (int i = 0; i < n; i++) {
            dfs(g, leftTop, i, 0, Integer.MIN_VALUE);
            dfs(g, rightBottom, i, m - 1, Integer.MIN_VALUE);
        }

        // 当两个边界二维数组在某个位置都为true时，符合题目要求
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (leftTop[i][j] && rightBottom[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        for (int[] cur : res) {
            System.out.println(cur[0] + " " + cur[1]);
        }
    }

    private static void dfs(int[][] g, boolean[][] vis, int x, int y, int pre) {
        if (x < 0 || x >= g.length || y < 0 || y >= g[0].length || vis[x][y]) {
            return;
        }
        if (g[x][y] < pre) return;
        vis[x][y] = true;
        dfs(g, vis, x + 1, y, g[x][y]);
        dfs(g, vis, x - 1, y, g[x][y]);
        dfs(g, vis, x, y + 1, g[x][y]);
        dfs(g, vis, x, y - 1, g[x][y]);
    }
}