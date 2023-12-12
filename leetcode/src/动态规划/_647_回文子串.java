package 动态规划;

public class _647_回文子串 {
    public int countSubstrings(String s) {
        //dp表示以s[i],s[j]结尾的子串是否为回文串。
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for(int i = 0; i < s.length();i++){
            dp[i][i] = true;
            res++;
        }
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    //是回文串
                    if(j - i == 1){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] == true){
                    res++;
                }
            }
        }
        return res;
    }
}
