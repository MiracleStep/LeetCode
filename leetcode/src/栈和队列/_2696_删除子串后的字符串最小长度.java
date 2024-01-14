package 栈和队列;

import java.util.Stack;

public class _2696_删除子串后的字符串最小长度 {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if ((ch == 'B' && stack.peek() == 'A') || (ch == 'D' && stack.peek() == 'C')) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
