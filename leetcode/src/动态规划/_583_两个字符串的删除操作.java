package 动态规划;

public class _583_两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //确定初始状态
        for(int i = 1; i <= word1.length();i++){
            //word1删除和word2的空相同所需的最小步骤
            dp[i][0] = i;
        }
        for(int j = 1; j <= word2.length(); j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    //不进行任何操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //删除word2或者删除word1
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
