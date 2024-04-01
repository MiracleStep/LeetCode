package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 全球变暖 {
    static char[][] mp = {
            {'.','.','.','.','.','.','.'},
            {'.','#','#','.','.','.','.'},
            {'.','#','#','.','.','.','.'},
            {'.','.','.','.','#','#','.'},
            {'.','.','#','#','#','#','.'},
            {'.','.','.','#','#','#','.'},
            {'.','.','.','.','.','.','.'}};
    static int n = 7;
    static boolean[][] vis = new boolean[n][n];
    static int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    static int flag;

    public static void main(String[] args) {
        int ans = 0;
        for(int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                if(!vis[i][j] && mp[i][j]=='#'){
                    //未被访问且为陆地
                    flag = 0;
                    bfs(i, j);
                    if(flag == 0){
                        //当前陆地被淹没
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()){
            //先判断条件
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if(vis[x][y] || mp[x][y] == '.') continue;
            //全部通过，开始对节点进行操作。
            vis[x][y] = true;
            if(mp[x-1][y] == '#' &&mp[x][y-1] == '#'&&mp[x+1][y] == '#'&&mp[x][y+1] == '#'){
                flag = 1;//存在内陆不会被淹没.
            }

            //再进行迭代
            for(int k = 0;k < 4;k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
