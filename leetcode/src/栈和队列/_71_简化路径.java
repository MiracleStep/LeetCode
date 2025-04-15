package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class _71_简化路径 {
    public String simplifyPath(String path) {
        int len = path.length();
        Deque<String> stack = new LinkedList<>();
        String[] names = path.split("/");
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.push(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        } else {
            while (!stack.isEmpty()) {
                sb.append("/");
                sb.append(stack.pollLast());
            }
        }
        return sb.toString();
    }
}
