package 回溯法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _78_子集 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        Stack<Integer> stack = new Stack<>();
        dfs(nums, stack, 0);
        return res;
    }

    public void dfs(int[] nums, Stack<Integer> stack, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        //不取
        dfs(nums, stack, index + 1);
        //取
        stack.push(nums[index]);
        dfs(nums, stack, index + 1);
        //回溯
        stack.pop();
    }
}
