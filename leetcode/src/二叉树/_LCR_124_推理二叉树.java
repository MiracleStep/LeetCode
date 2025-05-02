package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class _LCR_124_推理二叉树 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return deduceTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode deduceTree(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }
        int cur = preorder[pLeft];
        TreeNode node = new TreeNode(cur);
        int idx = map.get(cur);
        int count = idx - iLeft;
        node.left = deduceTree(preorder, inorder, pLeft + 1, pLeft + count, iLeft, idx - 1);
        node.right = deduceTree(preorder, inorder, pLeft + count + 1, pRight, idx + 1, iRight);
        return node;
    }
}
