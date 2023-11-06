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
}
