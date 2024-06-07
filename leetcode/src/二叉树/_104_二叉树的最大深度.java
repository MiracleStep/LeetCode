package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _104_二叉树的最大深度 {
    //层次遍历
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

    //递归法
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
