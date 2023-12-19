package 回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _39_组合总和 {
    public static void main(String[] args) {
        new _39_组合总和().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(target == 0){
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, 0, target, res, path);
        return res;
    }

    public void dfs(int[] candidates, int index, int target, List<List<Integer>> res, LinkedList<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i = index; i < candidates.length; i++){
            path.addLast(candidates[i]);
            dfs(candidates, i, target - candidates[i], res, path);
            //状态恢复
            path.removeLast();
        }
    }
}
