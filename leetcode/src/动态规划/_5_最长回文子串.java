package 动态规划;

public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        int len = s.length();
        //表示以s[i],s[j]结尾的字符串是否为回文串
        boolean[][] dp = new boolean[len][len];
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;//初始化
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //可能是回文串
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == true && maxLen < j - i + 1) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
