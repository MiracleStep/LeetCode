package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _513_找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftLastNodeVal = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            leftLastNodeVal = queue.peek().val;
            while(size-- > 0){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return leftLastNodeVal;
    }

    int maxDepth = -1, res = -1;
    //递归+前序遍历
    public int findBottomLeftValue2(TreeNode root) {
        leftValue(root, 0);
        return res;
    }

    private void leftValue(TreeNode root, int leftDepth){
        if(root == null){
            return ;
        }
        // 如果当前节点是叶子节点
        if(root.left == null && root.right == null){
            // 当前叶子节点的深度大于之前保存的最大深度
            // 证明是当前深度的最左边叶子节点，因为先递归左子树
            // 此时更新最大深度，更新结果值
            if(leftDepth > maxDepth){
                maxDepth = leftDepth;
                res = root.val;
            }
        }
        // 递归左子树
        leftValue(root.left, leftDepth + 1);
        // 递归右子树
        leftValue(root.right, leftDepth + 1);
    }

}
