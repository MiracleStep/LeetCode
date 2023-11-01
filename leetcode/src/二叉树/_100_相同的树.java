package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; //都为空
        if (p == null || q == null) return false; //一个为空

        if (p.val != q.val) return false; //比较
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);//递归比较子节点
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();// 初始化队列
        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty()){
            // 从队列中取出两个节点
            TreeNode pNode = queue.poll();
            TreeNode qNode = queue.poll();
            // 若当前为空，则继续循环
            if(pNode == null && qNode == null) continue;
            if(pNode == null || qNode == null) return false;
            // 如果两个节点皆不为空，但是节点的值不同，则一定不相同
            if(pNode.val != qNode.val) return false;
            // pNode 节点的左孩子和 qNode 节点的左孩子入队列
            queue.offer(pNode.left);
            queue.offer(qNode.left);

            // pNode 节点的右孩子和 qNode 节点的右孩子入队列
            queue.offer(pNode.right);
            queue.offer(qNode.right);
        }
        return true;
    }
}
