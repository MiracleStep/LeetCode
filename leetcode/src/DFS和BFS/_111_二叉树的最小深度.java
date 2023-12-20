package DFS和BFS;

import 二叉树.TreeNode;

public class _111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        //只有根节点，最小高度为1
        if(root.left == null && root.right == null) return 1;

        // 左子树最小值和右子树最小值
        int leftMindepth = minDepth(root.left);
        int rightMindepth = minDepth(root.right);

        // 如果节点的左子树不为空，右子树为空
        if(root.left != null && root.right == null){
            return leftMindepth + 1;
        }
        // 如果节点的右子树不为空，左子树为空
        if(root.left == null && root.right != null){
            return rightMindepth + 1;
        }
        //左右子树都不为空
        return Math.min(leftMindepth, rightMindepth) + 1;
    }
}
