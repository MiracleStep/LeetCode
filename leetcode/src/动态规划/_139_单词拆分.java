package 动态规划;

import java.util.List;

public class _139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];//以字符串i结尾是否可以拼接
        if (s.length() == 1) {
            return wordDict.contains(s.substring(0, 1));
        }
        dp[0] = wordDict.contains(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j] == true && wordDict.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
