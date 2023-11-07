package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _1382_将二叉搜索树变平衡 {
    //递归法：层次遍历构造有序数组 + 有序数组构造二叉搜索树
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return null;
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        return process(nums, 0, nums.size());
    }

    //二叉树中序递归遍历
    public void inOrder(TreeNode root, List<Integer> nums){
        if(root == null) return ;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    //有序数组构造二叉搜索树
    public TreeNode process(List<Integer> nums, int left, int right){
        if(right <= left) return null;
        int mid = (right + left) >> 1;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = process(nums, left, mid);
        root.right = process(nums, mid+1, right);
        return root;
    }
}
