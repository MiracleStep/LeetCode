package DFS;

import java.util.Scanner;

public class 地宫取宝2 {
    //记忆化递归实现
    static int n, m, k;
    static int[][] data;
    //10^9+7
    static int mod = (int) 1e9 + 7;
    static long[][][][] cache = new long[50][50][14][13];

    public static long dfs(int x, int y, int max, int cnt) {
        if (cache[x][y][max + 1][cnt] != -1) {//由于第一次max传入的是-1所以采用max+1的方法
            //之前已经得出这个状态的结果了可以提前结束。
            return cache[x][y][max + 1][cnt];
        }
        long ans = 0;
        if (x == n || y == m || cnt > k) {
            return 0;
        }
        int cur = data[x][y];
        if (x == n - 1 && y == m - 1) {
            if (cnt == k) {
                ans = ans % mod + 1;
            }
            if (cnt == k - 1 && cur > max) {
                ans = ans % mod + 1;
            }
            return ans;
        }


        if (cur > max) {//可以取这个物品
            ans += dfs(x, y + 1, cur, cnt + 1);
            ans += dfs(x + 1, y, cur, cnt + 1);
        }
        //对于价值较小，或者价值大胆不取这个物品的情况下
        ans += dfs(x, y + 1, max, cnt);
        ans += dfs(x + 1, y, max, cnt);

        cache[x][y][max + 1][cnt] = ans % mod;
        return ans % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        //初始化cache
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                for (int k = 0; k < 14; k++) {
                    for (int z = 0; z < 13; z++) {
                        cache[i][j][k][z] = -1;
                    }
                }
            }
        }
        System.out.println(dfs(0, 0, -1, 0));
        sc.close();
    }
}