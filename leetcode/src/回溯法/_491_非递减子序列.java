package 回溯法;

import java.util.*;

/**
 * @author Mirac
 * @date 23/9/2024
 */
public class _491_非递减子序列 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        dfs(deque, 0, nums);
        return res;
    }

    private void dfs(Deque<Integer> deque, int begin, int[] nums) {
        Set<Integer> set = new HashSet<>();//用于判重, 和子集II的做法不一样，因为子集II是排序后的。

        for (int i = begin; i < nums.length; i++) {
            if (set.contains(nums[i])) { //用于判断本次递归是否用到之前的数
                continue;
            }
            if (deque.isEmpty()) {
                deque.offer(nums[i]);
                set.add(nums[i]);
                dfs(deque, i + 1, nums);
                deque.pollLast();
            } else if (!deque.isEmpty() && deque.peekLast() <= nums[i]) {
                deque.offer(nums[i]);
                set.add(nums[i]);
                res.add(new ArrayList<>(deque));
                dfs(deque, i + 1, nums);
                deque.pollLast();
            }
        }
    }
}
