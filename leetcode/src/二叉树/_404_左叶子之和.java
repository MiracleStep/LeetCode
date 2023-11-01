package 二叉树;

public class _404_左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
            return sum + sumOfLeftLeaves(root.right);
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}

