package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Mirac
 * @date 10/10/2024
 */
public class _227_基本计算器II {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char preSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (preSign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                preSign = c;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
