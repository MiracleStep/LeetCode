package 动态规划;

public class _1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp i，j表示以text1 前i个和text2 前j个最长公共子序列的长度
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    //两个相同,找这两个前一个的最长公共子序列的长度
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    //两个不同
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
