package 二叉树;

public class _1038_从二叉搜索树到更大和树 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
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
