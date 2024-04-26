package 二叉树;

import java.util.Stack;

public class _530_二叉搜索树的最小绝对差 {
    //迭代法。
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int minSubVal = Integer.MAX_VALUE;
        TreeNode node = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tmp = stack.pop();
                if(pre != null){
                    minSubVal = Math.min(tmp.val - pre.val, minSubVal);
                }
                pre = tmp;
                node = tmp.right;
            }
        }
        return minSubVal;
    }

    int res = Integer.MAX_VALUE;
    int pre = -1;//因为难以获取到前一个节点，这里记录前一个节点的值
    public int getMinimumDifference2(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if (root == null) return ;
        dfs(root.left);
        if (pre == - 1) {
            pre = root.val;
        } else {
            res = Math.min(res, (root.val - pre));
            pre = root.val;
        }
        dfs(root.right);
    }
}
