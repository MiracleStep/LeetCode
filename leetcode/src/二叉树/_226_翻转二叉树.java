package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        //root.left = invertTree(root.right);
        //root.right = invertTree(root.left);不能直接写，因为交换其中子节点后，父节点的原来子节点被覆盖
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }

    //层序遍历
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }
        }

        return root;
    }
}
