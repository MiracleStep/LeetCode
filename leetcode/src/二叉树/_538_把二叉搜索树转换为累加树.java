package 二叉树;

import java.util.Stack;

public class _538_把二叉搜索树转换为累加树 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);//中序遍历，不过是右根左
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);//右
        sum += root.val;//根
        root.val = sum;
        dfs(root.left);//左
    }
}
