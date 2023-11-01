package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _239_滑动窗口最大值 {

    //ac
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        //单调数组：双端队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        Deque<Integer> deque = new LinkedList<>(); //也可以用LinkedList接收。
        //结果数组
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++){
            //单调数组。保证从小到大 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast(); //队列的值正常从队尾插入，队首出队。这里是从队尾出队。
            }
            //添加当前值对应的数组下标
            deque.offerLast(i);
            //判断是否需要移除队首值对应的下标
            if (deque.peek() <= i - k){
                deque.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }
    // 运行超时
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int[] max = new int[nums.length - k + 1];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            queue.offer(nums[i]);
        }
        max[0] = maxValue;

        for (int i = k; i < nums.length; i++) {
            int out = queue.poll();
            queue.offer(nums[i]);
            if (out != max[i - k]) {
                max[i - k + 1] = Math.max(max[i - k], nums[i]);
            } else {
                if (nums[i] >= out) {
                    max[i - k + 1] = nums[i];
                } else {
                    max[i - k + 1] = findMaxFromQueue(queue);
                }
            }
        }

        return max;
    }

    private int findMaxFromQueue(Queue<Integer> queue) {
        int maxValue = Integer.MIN_VALUE;
        for (Integer cur : queue) {
            maxValue = Math.max(maxValue, cur);
        }
        return maxValue;
    }


}
