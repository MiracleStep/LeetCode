package 二叉树;

public class LCR_053_二叉搜索树中的中序后继 {
    //function：中序遍历，找到第一个大于p.val的节点
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;//当前节点为空
        TreeNode left = inorderSuccessor(root.left, p);
        if (left != null) {//左边没有找到大于p.val的节点
            return left;
        }
        if (root.val > p.val) {//左边节点没有找到，那么中序遍历时当前节点看看是否找到
            return root;
        }
        return inorderSuccessor(root.right, p);//当前节点没有，那只能看右边节点了
    }
}
