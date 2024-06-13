package 二叉树;

import java.util.HashMap;

public class _437_路径总和III {
    int res = 0;
    HashMap<Long, Integer> map = new HashMap<>();//保存之前遍历到的前缀和和其个数
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        map.put(0l, 1);
        dfs(root, targetSum, 0);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, long preSum) {
        if (root == null) return;
        preSum += root.val;
        //得到我们想要前缀树的个数，想要前缀树值就是当前前缀树值减去目标值 路径可能有多个
        //例如10-0-5-3那么这样的路径为8的有两个
        res += map.getOrDefault(preSum - targetSum, 0);

        //将当前前缀树的值保存
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        dfs(root.left, targetSum, preSum);
        dfs(root.right, targetSum, preSum);
        //防止左边前缀树影响右边前缀树，左边前缀树可能有个为6，右边正好想要一个前缀树为6的，这样子就出错了
        map.put(preSum, map.get(preSum) - 1);
    }
}
