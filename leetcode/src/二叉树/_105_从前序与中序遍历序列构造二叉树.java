package 二叉树;

import java.util.HashMap;

public class _105_从前序与中序遍历序列构造二叉树 {
    HashMap<Integer, Integer> indexCache;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexCache = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexCache.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {
        if (pLeft > pRight) {
            return null;
        }
        int index = indexCache.get(preorder[pLeft]);
        // 先把根节点建立出来
        TreeNode cur = new TreeNode(preorder[pLeft]);
        //左子结点的数量
        int leftNum = index - iLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        cur.left = buildTree(preorder, inorder, pLeft + 1, pLeft + leftNum, iLeft, index - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        cur.right = buildTree(preorder, inorder, pLeft + leftNum + 1, pRight, index + 1, iRight);
        return cur;
    }
}
