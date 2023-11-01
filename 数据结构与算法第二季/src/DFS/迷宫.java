package DFS;

import java.util.Arrays;

public class 迷宫 {
    private static int n = 4;
    private static int ans = 0;
    private static char[][] mp = {
                                    {'U','L','D','L'},
                                    {'R','R','U','L'},
                                    {'L','R','D','L'},
                                    {'U','L','L','R'}};
    private static boolean[][] vis = new boolean[n][n]; //自动初始化为false

    public static void main(String[] args) {
        for (int i = 0; i < n;i++){
            System.out.println(Arrays.toString(mp[i]));
        }
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                for (int k = 0;k < n;k++) Arrays.fill(vis[k], false);
                if(dfs(i, j)) ans++;
            }
        }
        System.out.println("ans=" + ans);
    }

    //判断当前位置能否离开迷宫
    private static boolean dfs(int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= n) return true; //走出迷宫
        if(vis[i][j]) return false; //当前节点已经被访问过了。

        vis[i][j] = true; //标记已经搜索。
        if (mp[i][j] == 'L') return dfs(i, j-1);
        if (mp[i][j] == 'R') return dfs(i, j+1 );
        if (mp[i][j] == 'U') return dfs(i-1, j);
        if (mp[i][j] == 'D') return dfs(i+1, j);
        return false;
    }
}
