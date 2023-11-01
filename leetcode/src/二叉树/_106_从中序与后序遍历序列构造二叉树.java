package 二叉树;


import java.util.Arrays;

public class _106_从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        int n = inorder.length;
        TreeNode root = new TreeNode(postorder[n - 1]);
        for(int i = 0; i < n; i++){
            if(inorder[i] == postorder[n - 1]){
                int[] left_inorder = Arrays.copyOfRange(inorder, 0, i);
                int[] right_inorder = Arrays.copyOfRange(inorder, i + 1, n);
                int[] left_postorder = Arrays.copyOfRange(postorder, 0, i);
                int[] right_postorder = Arrays.copyOfRange(postorder, i, n - 1);

                root.left = buildTree(left_inorder, left_postorder);
                root.right = buildTree(right_inorder, right_postorder);
            }
        }
        return root;
    }
}
