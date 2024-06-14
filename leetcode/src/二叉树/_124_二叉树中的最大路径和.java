package 二叉树;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _124_二叉树中的最大路径和 {
    //递归法
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

    //树形DP
    Map<TreeNode, int[]> map = new HashMap<>(); // 节点: [父, 左, 右]
    public int maxPathSum2(TreeNode root) {
        dfs1(root, null);
        dfs2(root, null);
        int ans = Integer.MIN_VALUE;
        for (TreeNode cur : map.keySet()) {
            int t = cur.val;
            int[] info = map.get(cur);
            Arrays.sort(info);
            if (info[2] >= 0) t += info[2];
            if (info[1] >= 0) t += info[1];
            ans = Math.max(ans, t);
        }
        return ans;
    }
    int dfs1(TreeNode cur, TreeNode fa) {
        if (cur == null) return 0;
        int left = dfs1(cur.left, cur), right = dfs1(cur.right, cur);
        int[] info = map.getOrDefault(cur, new int[3]);
        info[1] = left; info[2] = right;
        map.put(cur, info);
        return Math.max(cur.val, cur.val + Math.max(left, right));
    }
    void dfs2(TreeNode cur, TreeNode fa) {
        if (cur == null) return ;
        int[] curInfo = map.get(cur);
        if (cur.left != null) {
            int[] leftInfo = map.get(cur.left);
            leftInfo[0] = Math.max(cur.val, cur.val + Math.max(curInfo[0], curInfo[2]));
        }
        if (cur.right != null) {
            int[] rightInfo = map.get(cur.right);
            rightInfo[0] = Math.max(cur.val, cur.val + Math.max(curInfo[0], curInfo[1]));
        }
        dfs2(cur.left, cur);
        dfs2(cur.right, cur);
    }
}
