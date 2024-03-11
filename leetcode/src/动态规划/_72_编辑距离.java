package 动态规划;

public class _72_编辑距离 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //将word1前i个字符转化为word2前j个字符所需要的最少操作次数
        //或者 dp表示以word1[i-1]、word2[j-1]为结尾的两个字符串的最少操作次数。（word1第i个，word2第j个）
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;//删除
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;//删除
        }
        //状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //相等：不需要新的操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //不相等：从左到右分别是：word1新增一个字符、word1删除一个字符、word1替换一个字符
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
