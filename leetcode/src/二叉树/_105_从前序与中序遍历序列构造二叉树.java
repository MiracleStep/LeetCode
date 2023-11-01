package 二叉树;

import java.util.Arrays;

public class _105_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 0; i < inorder.length; i++){
            //查找中序遍历数组的对应节点的索引
            if (preorder[0] == inorder[i]){
                // 找出中序遍历的左子树和右子树
                int[] left_inorder = Arrays.copyOfRange(inorder, 0, i);
                int[] right_inorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                // 找出前序遍历的左子树和右子树
                int[] left_preorder = Arrays.copyOfRange(preorder, 1, 1 + i);
                int[] right_preorder = Arrays.copyOfRange(preorder, 1 + i, preorder.length);
                // 递归构建左子树
                root.left = buildTree(left_preorder, left_inorder);
                // 递归构建右子树
                root.right = buildTree(right_preorder, right_inorder);
                break;
            }
        }

        return root;
    }
}
