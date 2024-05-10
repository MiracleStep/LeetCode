package 二叉树;

public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return binaryArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode binaryArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = binaryArrayToBST(nums, left, mid - 1);
        root.right = binaryArrayToBST(nums, mid + 1, right);
        return root;
    }
}
