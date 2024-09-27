package 二叉树;

public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        flatten(tmp);
        cur.right = tmp;
    }
}
