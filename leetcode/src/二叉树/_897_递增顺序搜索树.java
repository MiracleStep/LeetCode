package 二叉树;

public class _897_递增顺序搜索树 {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode();
        cur = dummyNode;
        inOrder(root);
        return dummyNode.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return ;
        inOrder(root.left);

        cur.right = root;
        root.left = null;
        cur = root;

        inOrder(root.right);
    }
    //直接递归，第一次写出来的，但是难想
    public TreeNode increasingBST2(TreeNode root) {
        if (root == null) return null;
        TreeNode left = increasingBST(root.left);
        if (left != null) {
            TreeNode node = left;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root;
            root.left = null;
        } else {
            left = root;
        }
        root.right = increasingBST(root.right);
        return left;
    }
}
