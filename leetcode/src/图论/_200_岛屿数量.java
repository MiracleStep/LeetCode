package 图论;

import java.util.LinkedList;
import java.util.Queue;

public class _200_岛屿数量 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '2'; //表示已经遍历过的陆地
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
    int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    public void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
                continue;
            }
            grid[x][y] = '2';//表示已经遍历过了
            //再进行迭代
            for(int k = 0;k < 4;k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                queue.offer(new int[]{nx, ny});
            }
        }
    }

}
