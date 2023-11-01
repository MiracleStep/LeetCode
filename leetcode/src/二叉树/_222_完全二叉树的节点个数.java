package 二叉树;

public class _222_完全二叉树的节点个数 {
    //计算树高,因为完全二叉树叶子结点都在树的最左边。
    //否则需要用层次遍历了。
    public int height(TreeNode root){
        int height = 0;
        while(root != null){
            root = root.left;
            height++;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        // 空树，节点数为 0
        if(root == null) return 0;
        // 求左子树和右子树的深度
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // 如果左子树的深度 = 右子树的深度，左子树为满二叉树
        // 如果左子树的深度 ＞ 右子树的深度，右子树为满二叉树
        if(leftHeight == rightHeight){
            return (((1 << leftHeight) - 1) + countNodes(root.right) + 1);
        } else {
            return (countNodes(root.left) + ((1 << rightHeight) - 1) + 1);
        }
    }
}
