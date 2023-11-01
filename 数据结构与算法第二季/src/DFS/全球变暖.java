package DFS;

import java.util.Scanner;

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
                    dfs(i, j);
                    if(flag == 0){
                        //当前陆地被淹没
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int i, int j) {
        //先确定初始状态(函数返回条件)
        //被访问过 or 海洋
        if(vis[i][j] || mp[i][j] == '.') return;
        //全部通过，开始对节点进行操作。
        vis[i][j] = true;
        if(mp[i-1][j] == '#' &&mp[i][j-1] == '#'&&mp[i+1][j] == '#'&&mp[i][j+1] == '#'){
            flag = 1;//存在内陆不会被淹没.
        }

        //再确定状态转移方程。
        for(int k = 0;k < 4;k++){
            int nx = i + dir[k][0];
            int ny = j + dir[k][1];
            dfs(nx, ny);
        }
    }
}
