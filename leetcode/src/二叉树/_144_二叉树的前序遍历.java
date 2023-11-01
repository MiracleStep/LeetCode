package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_二叉树的前序遍历 {
    //迭代法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            if (node != null){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tmp = stack.pop();
                node = tmp.right;
            }
        }
        return list;
    }

    //递归法
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversal(root, list);
        return list;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
