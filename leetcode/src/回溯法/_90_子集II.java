package 回溯法;

import java.util.*;

/**
 * @author Mirac
 * @date 20/9/2024
 */
public class _90_子集II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        // res.add(new ArrayList<>());
        Arrays.sort(nums);
        dfs(deque, 0, nums);
        return res;
    }

    private void dfs(Deque<Integer> deque, int begin, int[] nums) {
        res.add(new ArrayList<>(deque));

        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            deque.offer(nums[i]);
            // res.add(new ArrayList<>(deque));     //也可以放这里
            dfs(deque, i + 1, nums);
            deque.pollLast();
        }
    }
}
