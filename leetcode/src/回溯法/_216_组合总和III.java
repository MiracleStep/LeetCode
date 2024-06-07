package 回溯法;

import java.util.*;

public class _216_组合总和III {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return null;
        Arrays.sort(candidates);
        Deque<Integer> deque = new LinkedList<>();
        dfs(candidates, target, deque, 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, Deque<Integer> deque, int sum, int begin) {
        // if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {  //排序后的结果，超过直接返回
                break;
            }
            deque.offer(candidates[i]);
            dfs(candidates, target, deque, sum + candidates[i], i);
            deque.pollLast();
        }
    }
}
