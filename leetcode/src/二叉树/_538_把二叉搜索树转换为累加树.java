package 二叉树;

import java.util.Stack;

public class _538_把二叉搜索树转换为累加树 {
    public TreeNode convertBST(TreeNode root) {
        //反着遍历二叉树
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int sum = 0;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.right;
            } else {
                TreeNode tmp = stack.pop();
                int tmpVal = tmp.val;
                tmp.val += sum;
                sum += tmpVal;
                node = tmp.left;
            }
        }
        return root;
    }

    int preSum;
    public TreeNode convertBST2(TreeNode root) {
        preSum = 0;
        nodeSum(root);
        return root;
    }

    public void nodeSum(TreeNode node){
        if(node == null) return;
        nodeSum(node.right);
        node.val += preSum;
        preSum = node.val;
        nodeSum(node.left);
    }
}
