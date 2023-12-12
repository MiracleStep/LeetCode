package 动态规划;

public class _516_最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 1){
            return 1;
        }
        //dp表示区间[i, j]内最长回文串长度
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length();i++){
            dp[i][i] = 1;
        }
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i + 1; j < s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    //相等
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    //不相等
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
