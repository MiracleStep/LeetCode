package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        LinkedList<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                Node cur = queue.poll();
                tmpList.add(cur.val);

                for (Node node : cur.children) {
                    queue.offer(node);
                }
            }
            list.add(tmpList);
        }
        return list;
    }
}
