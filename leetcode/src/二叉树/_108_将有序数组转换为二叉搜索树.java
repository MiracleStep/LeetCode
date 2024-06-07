package 二叉树;

public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin >= end) return null;
        int mid = begin + (end - begin) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, begin, mid);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }
}
