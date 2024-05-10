package 二叉树;

public class _669_修剪二叉搜索树 {
    //确定状态：修建二叉树，删除低于low的，和高于high的节点
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);// 也就右边节点满足了
        else if (root.val > high) return trimBST(root.left, low, high);//也就左边节点满足了
        //low <= root.val <= high
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
