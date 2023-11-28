package 动态规划;

public class _72_编辑距离 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //dp表示以word1[i-1]、word2[j-1]为结尾的两个字符串的最少操作次数。（word1第i个，word2第j个）
        int[][] dp = new int[m+1][n+1];
        //初始化
        for(int i = 1; i <= m; i++){
            dp[i][0] = i;//word2第0个，相当于空。word1要删除i次。
        }
        for(int j = 1; j <= n; j++){
            dp[0][j] = j;
        }
        //状态转移
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    //相等：则不处理
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //不相等：删除word1[i-1]、删除word2[j-1]、替换word1[i-1](or word2)
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),  dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
