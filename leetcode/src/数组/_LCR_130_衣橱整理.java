package 数组;

public class _LCR_130_衣橱整理 {
    public int wardrobeFinishing(int m, int n, int cnt) {
        boolean[][] dp = new boolean[m][n];
        int count = 1;
        dp[0][0] = true;
        for (int i = 1; i < m; i++) {
            if (dp[i - 1][0] && (i / 10 + i % 10) <= cnt) {
                dp[i][0] = true;
                count++;
            }
        }
        for (int j = 1; j < n; j++) {
            if (dp[0][j - 1] && (j / 10 + j % 10) <= cnt) {
                dp[0][j] = true;
                count++;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if ((i / 10 + i % 10) + (j / 10 + j % 10) <= cnt && (dp[i - 1][j] || dp[i][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
