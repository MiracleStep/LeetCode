package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class _225_用队列实现栈 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public _225_用队列实现栈() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
        while (queue2 != null){
            queue1.offer(queue2.poll());
        }
        Queue<Integer> queue = queue1; //交换队列
        queue1 = queue2;
        queue2 = queue;
    }

    public int pop() {
        return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }
}
