package 二叉树;

public class _701_二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }

        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
