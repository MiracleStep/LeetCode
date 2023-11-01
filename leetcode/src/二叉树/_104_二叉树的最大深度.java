package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0; i < size;i++){
                TreeNode cur = queue.poll();

                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
