package 栈和队列;

import java.util.Stack;

public class _20_有效括号 {
    public boolean isValid(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
                continue;
            } else {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (chars[i] == ')' && pop != '(') return false;
                if (chars[i] == ']' && pop != '[') return false;
                if (chars[i] == '}' && pop != '{') return false;
            }

        }
        return stack.isEmpty();
    }
}
