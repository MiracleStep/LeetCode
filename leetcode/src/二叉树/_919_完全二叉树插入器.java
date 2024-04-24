package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _919_完全二叉树插入器 {
    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> queue; //依次保存所有需要待插入子节点的父节点。

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            //层次遍历
            Queue<TreeNode> tmp = new LinkedList<>();
            tmp.offer(root);
            while (!tmp.isEmpty()) {
                TreeNode cur = tmp.poll();
                if (cur.left != null) {
                    tmp.offer(cur.left);
                }
                if (cur.right != null) {
                    tmp.offer(cur.right);
                }
                if (cur.left == null || cur.right == null) {
                    queue.offer(cur);//需要插入子节点的父节点。
                }
            }
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            TreeNode cur = queue.peek();
            if (cur.left == null) {
                cur.left = node;

            } else if (cur.right == null) {
                cur.right = node;
                queue.poll();
            }
            queue.offer(node);
            return cur.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}