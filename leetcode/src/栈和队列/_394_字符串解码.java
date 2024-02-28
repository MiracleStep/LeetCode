package 栈和队列;

import java.util.Stack;

public class _394_字符串解码 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<String> prestrStack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                res.append(c);
            } else if (c == '[') { // 入栈
                numStack.push(num);
                prestrStack.push(res.toString());
                res = new StringBuilder();
                num = 0;
            } else if (c == ']') { //出栈
                StringBuilder tmp = new StringBuilder();
                int curNum = numStack.pop();
                for (int i = 0; i < curNum; i++) tmp.append(res.toString());
                res = new StringBuilder(prestrStack.pop() + tmp.toString());
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + Integer.parseInt(c + "");
            }
        }
        return res.toString();
    }
}
