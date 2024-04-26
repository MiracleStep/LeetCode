package 二叉树;

import java.util.*;

public class _98_验证二叉搜索树 {
    //迭代法，中序遍历
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        long pre = (long)Integer.MIN_VALUE - 1;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                if (pre < pop.val) {
                    pre = pop.val;
                } else {
                    return false;
                }
                node = pop.right;
            }
        }
        return true;
    }

    //递归法中序遍历。
    // long pre = Long.MIN_VALUE; 也可以这样
    TreeNode pre = null;
    //利用二叉树中序遍历是递增的来进行判断
    //函数功能判断当前二叉树是否是一个有效的二叉树
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;//递归基
        boolean left = isValidBST(root.left);//遍历左子树
        if (!left) {//判断左子树是否是有效二叉树
            return false;
        }
        if (pre != null && pre.val >= root.val) {//左子树遍历完了，判断当前节点值是否小于左子树节点
            return false;
        }
        pre = root;//更新pre值
        return isValidBST(root.right);//遍历右子树
    }
}
