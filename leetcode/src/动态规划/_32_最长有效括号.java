package 动态规划;

import java.util.Deque;
import java.util.LinkedList;

public class _32_最长有效括号 {
    class Solution {
        //栈 + 队列
        public int longestValidParentheses(String s) {
            if (s.length() == 0) {
                return 0;
            }
            char[] chars = s.toCharArray();
            Deque<Integer> stack = new LinkedList<>();
            //表示以i为结尾的最长有效括号子串的长度。
            int[] dp = new int[s.length()];
            stack.push(0);
            int res = 0;
            for (int i = 1; i < s.length(); i++) {
                if (chars[i] == ')') {
                    if (!stack.isEmpty() && chars[stack.peek()] == '(') {
                        //找到一对
                        int pop = stack.pop();
                        dp[i] = dp[i - 1] + 2;
                        if (pop > 0) {
                            dp[i] += dp[pop - 1];
                        }
                        res = Math.max(res, dp[i]);
                    }
                } else {
                    stack.push(i);
                }
            }
            return res;
        }
        //动态规划 最优
        public int longestValidParentheses2(String s) {
            if (s.length() == 0) {
                return 0;
            }
            char[] chars = s.toCharArray();
            Deque<Integer> stack = new LinkedList<>();
            //表示以i为结尾的最长有效括号子串的长度。
            int[] dp = new int[s.length()];
            stack.push(0);
            int res = 0;
            for (int i = 1; i < s.length(); i++) {
                if (chars[i] == ')') {
                    if (chars[i - 1] == '(') {
                        //情况1：……()
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && chars[i - dp[i - 1] - 1] == '(') {
                        //情况2：……))
                        dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    res = Math.max(res, dp[i]);
                }
            }
            return res;
        }
    }
}
