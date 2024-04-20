package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _113_路径总和II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Deque<Integer> deque = new LinkedList<>();
        dfs(root, 0, deque, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> deque, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        deque.offerLast(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                res.add(new ArrayList<>(deque));
            }
            deque.removeLast();//回溯
            return;
        }
        dfs(root.left, sum, deque, targetSum);
        dfs(root.right, sum, deque, targetSum);
        deque.removeLast();
    }
}
