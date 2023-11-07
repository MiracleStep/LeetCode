package 二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _110_平衡二叉树 {
    //计算二叉树的高度，同时计算二叉树是否平衡
    public int judgeHeight(TreeNode root) {
        if (root == null) return 0;

        //计算左子树的高度
        int leftHeight = judgeHeight(root.left);
        if (leftHeight == -1) {
            return -1;//左子树不平衡
        }
        //计算右子树的高度
        int rightHeight = judgeHeight(root.right);
        if (rightHeight == -1) {
            return -1;//右子树不平衡
        }

        if (Math.abs(rightHeight - leftHeight) > 1) {
            return -1;//二叉树不平衡
        } else {
            return Math.max(leftHeight, rightHeight) + 1;//计算高度
        }

    }
    //递归法
    public boolean isBalanced(TreeNode root) {
        if (judgeHeight(root) != -1) {
            return true;
        }
        return false;
    }

    //迭代法
    public boolean isBalanced2(TreeNode root) {
        if(root == null){
            return true;
        }
        // 判断以二叉树的每个节点为根的二叉树是否符合平衡二叉树的条件
        // 这里遍历二叉树的每个节点使用的是中序遍历（非递归）
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.add(root);
                root = root.left;
            }
            else{
                TreeNode cur = stack.pop();
                if(Math.abs(maxDepth(cur.left) - maxDepth(cur.right)) > 1){
                    return false;
                }
                root = cur.right;
            }
        }
        return true;
    }

    public int maxDepth(TreeNode root){
        // 空树，高度为 0
        if(root == null){
            return 0;
        }
        // 初始化队列和层次
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        // 当队列不为空
        while(!queue.isEmpty()){
            // 当前层的节点数
            int n = queue.size();
            // 弹出当前层的所有节点，并将所有子节点入队列
            for(int i =0; i < n; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth ++;
        }
        // 二叉树最大层次即为二叉树最大高度
        return depth;
    }


}
