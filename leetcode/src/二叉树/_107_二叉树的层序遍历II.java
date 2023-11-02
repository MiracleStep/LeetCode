package 二叉树;

import java.util.*;

public class _107_二叉树的层序遍历II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();

                tmpList.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.addFirst(tmpList);
        }
        return list;
    }
}
