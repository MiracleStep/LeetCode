package 回溯法;

import java.util.*;

public class _78_子集 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        dfs(deque, 0, nums);
        return res;
    }

    private void dfs(Deque<Integer> deque, int begin, int[] nums) {
        res.add(new ArrayList<>(deque));

        for (int i = begin; i < nums.length; i++) {
            deque.offer(nums[i]);
            dfs(deque, i + 1, nums);
            deque.pollLast();
        }
    }
}
