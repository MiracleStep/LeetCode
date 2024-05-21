package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _239_滑动窗口最大值 {

    //ac
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();//维护一个单调队列（单调递减）,保存的元素是索引
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                //移除所有小于当前值的元素,因为是维护一个单调递减的队列。（元素失效了）
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= i - k) {//保存索引的原因
                deque.pollFirst();//移除旧的元素
            }
            if (i >= k - 1) {
                //有k个数了
                res[i - k + 1] = nums[deque.peekFirst()];//获取当前最大值
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
