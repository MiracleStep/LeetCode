package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class LCR_041_数据流中的移动平均值 {
    Deque<Integer> deque;
    int size;
    int sum;
    /** Initialize your data structure here. */
    public LCR_041_数据流中的移动平均值(int size) {
        this.size = size;
        this.deque = new LinkedList<>();
        this.sum = 0;
    }

    public double next(int val) {
        if (deque.size() == size) {
            sum -= deque.removeFirst();
        }
        sum += val;
        deque.offer(val);
        return (double) sum / deque.size();
    }
}
