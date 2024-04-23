package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class _933_最近的请求次数 {
    Deque<Integer> deque;
    public _933_最近的请求次数() {
        this.deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.offer(t);
        while (deque.peekFirst() < (t - 3000)) {
            deque.pollFirst();
        }
        return deque.size();
    }
}
