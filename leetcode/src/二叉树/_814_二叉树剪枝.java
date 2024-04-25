package 二叉树;

public class _814_二叉树剪枝 {
    public TreeNode pruneTree(TreeNode root) {
        if (dfs(root)) {
            return root;
        } else {
            return null;
        }
    }
    //dfs函数功能：判断当前节点及其子树是否包含1如果包含返回True，如果为空或者不包含返回False
    private boolean dfs(TreeNode root) {
        if (root == null) return false;

        boolean left = dfs(root.left);
        if (!left) {
            root.left = null;
        }
        boolean right = dfs(root.right);
        if (!right) {
            root.right = null;
        }
        return root.val != 0 || left || right;
    }
}
