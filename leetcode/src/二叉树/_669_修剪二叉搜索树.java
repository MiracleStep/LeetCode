package 二叉树;

public class _669_修剪二叉搜索树 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;

        if(root.val < low){
            return trimBST(root.right, low, high);
        }
        if(root.val > high){
            return trimBST(root.left, low, high);
        }
        //root.val在这个区间
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
