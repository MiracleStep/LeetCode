package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class _437_路径总和III {
    Map<Long, Integer> map = new HashMap<Long, Integer>();//保存前缀和
    int target;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        map.put(0L, 1);//前缀和为0的个数至少是一个
        return dfs(root, 0L);
    }

    private int dfs(TreeNode root, Long curSum) {
        if (root == null) return 0;
        curSum += root.val;//得到当前前缀树的值
        int res = 0;
        res = map.getOrDefault(curSum - target, 0);//得到我们想要前缀树的个数，想要前缀树值就是当前前缀树值减去目标值
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);//将当前前缀树的值保存
        int left = dfs(root.left, curSum);//遍历左边
        int right = dfs(root.right, curSum);//遍历右边
        map.put(curSum, map.get(curSum) - 1);//防止左边前缀树影响右边前缀树，左边前缀树可能有个为6，右边正好想要一个前缀树为6的，这样子就出错了
        return res + left + right;
    }
}
