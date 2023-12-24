package DFS和BFS;

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

    //BFS
    public int numIslands2(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    //进行BFS
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        if(x < 0 || x >= m || y < 0 || y >= n){
                            continue;
                        }
                        if(grid[x][y] != '1'){
                            continue;
                        }
                        grid[x][y] = '2';//已经访问过
                        queue.offer(new int[]{x + 1, y});
                        queue.offer(new int[]{x - 1, y});
                        queue.offer(new int[]{x, y + 1});
                        queue.offer(new int[]{x, y - 1});
                    }
                }
            }
        }
        return res;
    }
}
