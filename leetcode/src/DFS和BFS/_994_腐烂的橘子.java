package DFS和BFS;

import java.util.LinkedList;
import java.util.Queue;

public class _994_腐烂的橘子 {
    //BFS
    int dir[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0; //统计好橘子的数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        //BFS
        int res = 0;
        while (count > 0 && !queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        //没有越界并且是新鲜橘子
                        grid[nx][ny] = 2;//变成烂橘子
                        count--;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return count > 0 ? -1 : res;
    }
}
