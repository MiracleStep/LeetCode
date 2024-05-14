package 二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class _173_二叉搜索树迭代器 {
    TreeNode node;
    Deque<TreeNode> stack = new LinkedList<>();

    //中序遍历的非递归拆开？
    public _173_二叉搜索树迭代器(TreeNode root) {
        node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        TreeNode pop = stack.pop();
        node = pop.right;
        return pop.val;
    }

    public boolean hasNext() {
        return node != null || !stack.isEmpty();
    }
}
