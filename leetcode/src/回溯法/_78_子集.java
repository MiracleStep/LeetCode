package 回溯法;

import java.util.*;

public class _78_子集 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        // res.add(new ArrayList<>());
        dfs(deque, nums, 0);
        return res;
    }

    private void dfs(Deque<Integer> deque, int[] nums, int begin) {
        res.add(new ArrayList<>(deque));

        for (int i = begin; i < nums.length; i++) {
            deque.offer(nums[i]);
            // res.add(new ArrayList<>(deque));     //也可以放这里
            dfs(deque, nums, i + 1);
            deque.pollLast();
        }
    }
}
