package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _572_另一棵树的子树 {
    //层序遍历迭代 + 递归
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == subRoot.val) {
                if (dfs(poll, subRoot)) return true;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return false;
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        if (!dfs(left.left, right.left)) return false;
        if (!dfs(left.right, right.right)) return false;
        return true;
    }
}
