package 栈和队列;

import java.util.Stack;

public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String cur : tokens){
            if (cur.equals("+")) {
                stack.push((stack.pop() + stack.pop()));
                continue;
            }
            if (cur.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
                continue;
            }
            if (cur.equals("*")) {
                stack.push(stack.pop() * stack.pop());
                continue;
            }
            if (cur.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
                continue;
            }
            //不是符号就是数字了
            stack.push(Integer.valueOf(cur));
        }
        return stack.pop();
    }
}
