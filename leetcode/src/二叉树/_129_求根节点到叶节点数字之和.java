package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _129_求根节点到叶节点数字之和 {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += sum;
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
