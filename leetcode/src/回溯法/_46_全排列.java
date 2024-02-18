package 回溯法;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _46_全排列 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
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
            if (vis[i] == true) continue;
            vis[i] = true;
            deque.offer(nums[i]);
            dfs(nums, deque, vis, index + 1);
            //回溯操作
            deque.pollLast();
            vis[i] = false;
        }
    }
}
