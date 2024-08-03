package 堆;

import java.util.PriorityQueue;

public class _295_数据流的中位数 {
    PriorityQueue<Integer> A, B;
    //建立一个 小顶堆 A 和 大顶堆 B，各保存列表的一半元素
    public _295_数据流的中位数() {
        A = new PriorityQueue<>();  //存储较大的那一半元素
        B = new PriorityQueue<>((x, y) -> (y - x));  //存储较小的那一半元素
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {  //向A添加元素，因为num可能是较小的元素，先存储过滤排序一下。
            B.offer(num);
            A.offer(B.poll());
        } else {  //向B添加元素
            A.offer(num);
            B.offer(A.poll());
        }
    }

    public double findMedian() {
        return A.size() == B.size() ? (double)(A.peek() + B.peek()) / 2 : A.peek();
    }
}
