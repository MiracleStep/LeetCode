package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
                node = tmp.right;
            }
        }
        return list;
    }
}
