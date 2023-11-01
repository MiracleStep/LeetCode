package DFS;

import java.util.Scanner;

public class 地宫取宝 {
    //dfs实现 但会超时
    static int n, m, k;
    static int[][] data;
    static long ans = 0;
    //10^9+7
    static int mod = (int) 1e9 + 7;

    public static void dfs(int x, int y, long max, int cnt) {
        if (x == n || y == m || cnt > k) return; //越界了。
        int cur = data[x][y];
        if (x == n - 1 && y == m - 1) {
            if (cnt == k) {
                ans = ans % mod + 1;
            }
            if (cnt == k - 1 && cur > max) {
                ans = ans % mod + 1;
            }
            return;
        }


        if (cur > max) {//可以取这个物品
            dfs(x, y + 1, cur, cnt + 1);
            dfs(x + 1, y, cur, cnt + 1);
        }
        //对于价值较小，或者价值大胆不取这个物品的情况下
        dfs(x, y + 1, max, cnt);
        dfs(x + 1, y, max, cnt);
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
        dfs(0, 0, -1, 0);//第一个点的价值可能是0
        System.out.println(ans);
        sc.close();
    }
}
