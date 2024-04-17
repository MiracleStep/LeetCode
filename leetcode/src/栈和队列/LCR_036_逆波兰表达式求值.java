package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class LCR_036_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                if (s.equals("+")) {
                    stack.push(left + right);
                } else if (s.equals("-")) {
                    stack.push(left - right);
                } else if (s.equals("*")) {
                    stack.push(left * right);
                } else {
                    stack.push(left / right);
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
