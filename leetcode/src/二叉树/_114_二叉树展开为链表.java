package 二叉树;

public class _114_二叉树展开为链表 {
    //解法1
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            //左节点cur遍历到头了
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    //解法2
    public void flatten2(TreeNode root) {
        dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.right;
        root.right = dfs(root.left);
        root.left = null;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }

        cur.right = dfs(tmp);
        return root;
    }
}
