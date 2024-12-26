package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class _20_有效括号 {
    public boolean isValid(String s){
        Deque<Character> stack = new LinkedList<>();
        int len = s.length();
        for(int i = 0;i < len;i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else { // 右括号s
                if(stack.isEmpty()) return false;
                char left = stack.pop();
                if(left == '(' && c != ')') return false;
                if(left == '[' && c != ']') return false;
                if(left == '{' && c != '}') return false;
            }
        }

        return stack.isEmpty();
    }
}
