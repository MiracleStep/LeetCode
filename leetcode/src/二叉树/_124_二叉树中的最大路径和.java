package 二叉树;

public class _124_二叉树中的最大路径和 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    //传入当前节点root，返回以该节点“往下”延伸所能取得的最大路径和。（往左下 or 右下）
    //仅使用当前节点、使用当前节点和左子树路径或右子树路径 和 使用当前节点和左右子树路径 三者中取最大值进行返回。
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int cur = root.val;
        int left = dfs(root.left);
        int right = dfs(root.right);

        //计算以当前节点为中间结点的路径之和
        if (left > 0) cur += left;
        if (right > 0) cur += right;
        ans = Math.max(ans, cur);

        return Math.max(root.val, Math.max(left, right) + root.val);
    }
}
