package 动态规划;

public class _392_判断子序列 {
    public boolean isSubsequence(String s, String t) {
        //dp 表示s的前i个，t的前j个子序列的长度
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    //相同
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int m = s.length(), n = t.length();
        int left = 0, right = 0;
        while (left < m && right < n) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == s.length();
    }
}
