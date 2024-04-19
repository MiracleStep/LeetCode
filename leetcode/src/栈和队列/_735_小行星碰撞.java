package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class _735_小行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];
            while (!stack.isEmpty() && cur < 0 && stack.peek() > 0) {
                if (cur + stack.peek() < 0) {
                    stack.pop();
                } else if (cur + stack.peek() > 0){
                    cur = 0;
                    break;
                } else {
                    cur = 0;
                    stack.pop();
                    break;
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
