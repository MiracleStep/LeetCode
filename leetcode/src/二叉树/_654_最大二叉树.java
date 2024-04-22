package 二叉树;

import java.util.Arrays;
import java.util.List;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end){
        if(end <= start) return null;
        int iMax = start;
        for(int i = start; i < end; i++){
            if(nums[i] > nums[iMax]){
                iMax = i;
            }
        }

        TreeNode cur = new TreeNode(nums[iMax]);
        cur.left = constructMaximumBinaryTree(nums, start, iMax);
        cur.right = constructMaximumBinaryTree(nums, iMax + 1, end);
        return cur;
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int iMax = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[iMax]){
                iMax = i;
            }
        }

        TreeNode cur = new TreeNode(nums[iMax]);
        cur.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, iMax));
        cur.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, iMax + 1, nums.length));
        return cur;
    }
}
