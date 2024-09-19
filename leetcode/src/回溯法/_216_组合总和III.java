package 回溯法;

import java.util.*;

public class _216_组合总和III {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0) return res;
        Deque<Integer> deque = new LinkedList<>();
        dfs(k, n, 1, 0, deque, 0);
        return res;
    }

    private void dfs(int k, int n, int begin, int sum, Deque<Integer> deque, int count) {
        // if (sum > n) {
        //     //剪枝
        //     return;
        // }
        if (count == k && sum == n) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = begin; i <= 9; i++) {
            if (sum + i > n) {
                //剪枝
                break;
            }
            deque.offer(i);
            dfs(k, n, i + 1, sum + i, deque, count + 1);
            deque.pollLast();
        }
    }
}
