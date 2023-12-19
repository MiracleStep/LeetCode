package 回溯法;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, len, used, path, res);
        return res;
    }

    public void dfs(int[] nums, int len, boolean[] used, Deque<Integer> path, List<List<Integer>> res){
        if(path.size() == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i++){
            if(used[i] == false){
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, used, path, res);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
