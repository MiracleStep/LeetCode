package 二叉树;

public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        if(left == null && right == null){
            return null;
        }
        return left != null ? left : right;
    }
}
