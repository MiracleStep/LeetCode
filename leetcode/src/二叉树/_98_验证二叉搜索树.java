package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _98_验证二叉搜索树 {
    //迭代法，中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tmp = stack.pop();
                if (pre != null && tmp.val <= pre.val) {
                    return false;
                }
                pre = tmp;
                node = tmp.right;
            }
        }
        return true;
    }
    //递归法：中序遍历
    public boolean isValidBST2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inOrder(root, res);
        // 判断 res 是否有序
        for(int i = 1; i < res.size(); i++){
            if(res.get(i) <= res.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    // 中序遍历
    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }


}
