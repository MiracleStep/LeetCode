package 二叉树;

public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left); //flatten左节点
        flatten(root.right);//flatten右节点
        TreeNode cur = root.left;
        if (cur != null) {//flatten的左节点不为空
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
