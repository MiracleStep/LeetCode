package 回溯法;

import java.util.*;

/**
 * @author Mirac
 * @date 15/10/2024
 */
public class _47_全排列_II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int\[] nums) {
        Arrays.sort(nums);
        Deque<Integer> deque = new LinkedList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(nums, deque, vis, 0);
        return res;
    }

    private void dfs(int[] nums, Deque<Integer> deque, boolean[] vis, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && vis[i - 1])) {
                continue;
            }
            vis[i] = true;
            deque.offer(nums[i]);
            dfs(nums, deque, vis, index + 1);
            vis[i] = false;
            deque.pollLast();
        }
    }
}
