package 回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _39_组合总和 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs(candidates, list, 0, 0, target);
        return res;
    }

    private void dfs(int[] candidates, List<Integer> list, int index, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {//超过target值了直接返回，剪枝
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            dfs(candidates, list, i, sum + candidates[i], target);
            list.remove(list.size() - 1);
        }
    }
}
