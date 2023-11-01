package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                tmpList.add(node.val);

                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            list.add(tmpList);
        }
        return list;
    }
}
