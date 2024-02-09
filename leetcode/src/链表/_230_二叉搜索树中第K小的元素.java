package 链表;

import 二叉树.TreeNode;

import java.util.Stack;

public class _230_二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        //中序遍历
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tmp = stack.pop();
                if (--k == 0) {
                    return tmp.val;
                }
                node = tmp.right;
            }
        }
        return 0;
    }
}
