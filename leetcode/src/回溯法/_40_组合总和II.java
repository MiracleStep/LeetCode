package 回溯法;

import java.util.*;

public class _40_组合总和II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        Deque<Integer> deque = new LinkedList<>();
        dfs(candidates, target, 0, 0, deque);
        return res;
    }

    private void dfs(int[] candidates, int target, int sum, int begin, Deque<Integer> deque) {
        // if (sum > target)  {
        //     return;
        // }
        if (sum == target) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (sum + candidates[i] > target) {
                break;
            }

            deque.offer(candidates[i]);
            dfs(candidates, target, sum + candidates[i], i + 1, deque);
            deque.pollLast();
        }
    }
}
