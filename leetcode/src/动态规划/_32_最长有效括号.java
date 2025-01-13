package 动态规划;

public class _32_最长有效括号 {

    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        //表示以i为结尾的最长有效括号子串的长度。
        int[] dp = new int[s.length()];
        dp[0] = 0;

        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else {
                    if (dp[i - 1] >= 2 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                res =  Math.max(dp[i], res);
            }
        }
        return res;
    }
}
