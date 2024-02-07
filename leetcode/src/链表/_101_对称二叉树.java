package 链表;

import 二叉树.TreeNode;

public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return isSymmetric(L.left, R.right) && isSymmetric(L.right, R.left);
    }
}
