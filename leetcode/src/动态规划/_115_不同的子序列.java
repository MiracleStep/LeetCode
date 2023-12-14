package 动态规划;

public class _115_不同的子序列 {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        //dp表示s字符串前i个和t字符串前j个 s中出现t的不同子序列的个数
        int[][] dp = new int[n+1][m+1];
        //对于第一行, t为空,因为空集是所有字符串子集, 所以我们第一行都是 1
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
    //滚动数组优化
    public int numDistinct2(String s, String t) {
        int n = s.length(), m = t.length();
        //dp表示s字符串前i个和t字符串前j个 s中出现t的不同子序列的个数
        int[][] dp = new int[2][m+1];
        //对于第一行, t为空,因为空集是所有字符串子集, 所以我们第一行都是 1
        for(int i = 0; i <= n; i++){
            dp[i%2][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i%2][j] = dp[(i - 1)%2][j - 1] + dp[(i - 1)%2][j];
                } else {
                    dp[i%2][j] = dp[(i - 1)%2][j];
                }
            }
        }
        return dp[n%2][m];
    }
}
