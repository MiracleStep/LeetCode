package 回溯法;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _77_组合 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k || k <= 0) return res;
        Deque<Integer> deque = new LinkedList<>();
        dfs(deque, 1, n, k, 0);
        return res;
    }

    private void dfs(Deque<Integer> deque, int begin, int n, int k, int count) {
        if (count == k) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i <= n; i++) {
            deque.offer(i);
            dfs(deque, i + 1, n, k, count + 1);
            deque.removeLast();
        }
    }
}
