package 堆;

import java.util.PriorityQueue;

public class _295_数据流的中位数 {
    PriorityQueue<Integer> A, B;
    //建立一个 小顶堆 A 和 大顶堆 B，各保存列表的一半元素
    public _295_数据流的中位数() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {
            B.offer(num);
            A.offer(B.poll());
        } else {
            A.offer(num);
            B.offer(A.poll());
        }
    }

    public double findMedian() {
        return A.size() == B.size() ? (double)(A.peek() + B.peek()) / 2 : A.peek();
    }
}
