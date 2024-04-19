import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];
            while (!stack.isEmpty()) {
                int peek = stack.peek();
                if (cur > 0) {
                    if (peek < 0) {
                        if (cur + peek > 0) {
                            stack.pop();
                        } else {
                            cur = 0;
                        }
                    } else {
                        stack.push(cur);
                        cur = 0;
                        break;
                    }
                } else {
                    if (peek < 0) {
                        stack.push(cur);
                        cur = 0;
                        break;
                    } else {
                        if (cur + peek < 0) {
                            stack.pop();
                        } else {
                            cur = 0;
                        }
                    }
                }
            }
            if (cur != 0) {
                stack.push(cur);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[res.length -i - 1] = stack.pop();
        }
        return res;
    }
}
