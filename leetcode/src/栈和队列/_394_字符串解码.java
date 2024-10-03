package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class _394_字符串解码 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> prestrStack = new LinkedList<>();

        for (Character c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= '0' && c<= '9') {
                num = num * 10 + Integer.parseInt(c + "");
            } else if (c == '[') {//入栈
                numStack.push(num);
                prestrStack.push(sb.toString());
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {//出栈
                StringBuilder tmp = new StringBuilder();
                int curNum = numStack.pop();
                for (int i = 0; i < curNum; i++) tmp.append(sb.toString());
                sb = new StringBuilder(prestrStack.pop() + tmp.toString());
            }
        }
        return sb.toString();
    }
}
