package 二叉树;

import java.util.LinkedList;

public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;//都为空
        if(left == null || right == null) return false; //有一个为空

        if(left.val != right.val) return false;//比较是否相同
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left); //递归遍历子节点。
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root==null) {
            return true;
        }
        // 初始化队列
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size() > 0) {
            // 从队列中取出两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            // 若两个节点都为空（左右节点不存在），则继续循环
            if(left == null && right == null) {
                continue;
            }
            // 左节点为空右节点不为空或左节点不为空右节点为空，则不对称
            if((left == null && right != null) || (left != null && right == null)){
                return false;
            }
            // 左右节点不为空，但数值不等，则不对称
            if(left.val != right.val) {
                return false;
            }
            // 左节点的左孩子和右节点的右孩子入队列
            queue.add(left.left);
            queue.add(right.right);
            // 左节点的右孩子和右节点的左孩子入队列
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
