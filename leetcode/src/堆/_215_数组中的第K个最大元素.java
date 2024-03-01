package 堆;

import java.util.PriorityQueue;

public class _215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();//维护容量为k的小跟队
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();//如果大于k，把最小的poll掉
            }
        }
        return heap.peek();
    }
}
