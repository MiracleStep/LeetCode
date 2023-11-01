package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;

        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (cur.left == pre || pre == cur.right))){
                list.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
        return list;
    }
}
