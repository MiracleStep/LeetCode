package 回溯法;

import java.util.*;

public class _78_子集 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        Deque<Integer> deque = new LinkedList<>();
        dfs(nums, deque, 0);
        return res;
    }

    public void dfs(int[] nums, Deque<Integer> deque, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        //不取
        dfs(nums, deque, index + 1);
        //取
        deque.offer(nums[index]);
        dfs(nums, deque, index + 1);
        //回溯
        deque.pollLast();
    }

    public static void main(String[] args) {
        new _78_子集().subsets2(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets2(int[] nums) {
        if (nums.length == 0) return res;
        Deque<Integer> deque = new LinkedList<>();
        res.add(new ArrayList<>());
        dfs2(nums, deque, 0);
        return res;
    }

    private void dfs2(int[] nums, Deque<Integer> deque, int index) {
        if (index == nums.length) return;
        for (int i = index; i < nums.length; i++) {
            deque.offer(nums[i]);
            res.add(new ArrayList<>(deque));
            dfs(nums, deque, i + 1);
            deque.pollLast();
        }
    }
}
