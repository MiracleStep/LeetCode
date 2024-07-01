package 回溯法;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _131_分割回文串 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) {
            return res;
        }

        Deque<String> deque = new LinkedList<>();

        //动态规划：回文子串题目
        boolean[][] dp = new boolean[len][len];//s[i]-s[j]是否为回文串
        for (int i = 0; i < len; i++) {//初始化
            dp[i][i] = true;
        }
        //确定状态转移方程和状态转移顺序
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        //开始dfs，dp作为判断是否是回文串的依据。
        dfs(s, deque, 0, dp);
        return res;
    }

    private void dfs(String s, Deque<String> deque, int index, boolean[][] dp) {
        //递归基
        if (index == s.length()) {
            res.add(new ArrayList<>(deque));
            return;
        }

        //遍历
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {  //index - i 是回文串
                deque.offer(s.substring(index, i + 1));  //截取index - i 的回文串.
                //dfs 从i + 1开始
                dfs(s, deque, i + 1, dp);
                deque.removeLast();  //回溯
            }
        }
    }
}
