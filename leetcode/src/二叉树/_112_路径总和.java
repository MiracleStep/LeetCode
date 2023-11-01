package 二叉树;

import java.util.Stack;

public class _112_路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        //左右子节点都为空，为叶子结点。
        if(root.left == null && root.right == null) return root.val == targetSum;
        //递归左右子树。
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        // 如果树为空，返回 False
        if(root == null){
            return false;
        }
        // 初始化栈
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackVal = new Stack<>();
        stack.push(root);
        stackVal.push(root.val);

        while(!stack.isEmpty()){
            int n = stack.size();
            for(int i = 0; i < n; i++){
                TreeNode node = stack.pop();
                int val = stackVal.pop();
                // 如果当前节点为叶子节点且路径总和 = targetSum
                if(node.left == null && node.right == null && val == targetSum){
                    return true;
                }
                // 右子树入栈
                if(node.right != null){
                    stack.push(node.right);
                    stackVal.push(val + node.right.val);
                }
                // 左子树入栈
                if(node.left != null){
                    stack.push(node.left);
                    stackVal.push(val + node.left.val);
                }
            }
        }
        return false;
    }
}
