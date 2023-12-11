package 动态规划;

import 二叉树.TreeNode;

public class _337_打家劫舍III {
    private int[] rob_root(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        // 后续遍历，记录左右节点的值
        int []left = rob_root(root.left);
        int []right = rob_root(root.right);
        // 初始化 dp
        int []dp = new int[2];
        // 下标为 0 的表示不偷当前房子（父节点）
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 下标为 1 的表示偷当前房子（父节点）
        dp[1] = root.val + left[0] + right[0];

        return dp;
    }

    public int rob(TreeNode root) {
        int []res = rob_root(root);
        return Math.max(res[0], res[1]);
    }
}
