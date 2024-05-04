package 二叉树;

import java.util.*;

public class _297_二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";//为null也要返回值，这样才能判断不为空的节点是否是最后的节点
        }
        //前序遍历
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(split));
        return dfs(queue);
    }

    //同样进行前序遍历
    private TreeNode dfs(Queue<String> queue) {
        String poll = queue.poll();
        if ("null".equals(poll)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(poll));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }
}
