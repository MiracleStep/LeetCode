package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class _239_滑动窗口最大值 {
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
            if (i >= k - 1) {
                if (deque.peekFirst() <= i - k) {//保存索引的原因
                    deque.pollFirst();//移除旧的元素
                }
                //有k个数了
                res[i - k + 1] = nums[deque.peekFirst()];//获取当前最大值
            }
        }
        return res;
    }
}
