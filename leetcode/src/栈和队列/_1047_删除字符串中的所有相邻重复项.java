package 栈和队列;

import java.util.Stack;

public class _1047_删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        for(int i = 0; i < chars.length; i++){
            if (!stack.isEmpty() && stack.peek() == chars[i]){
                stack.pop();
                continue;
            }
            stack.push(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
