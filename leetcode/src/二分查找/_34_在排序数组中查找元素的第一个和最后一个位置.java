package 二分查找;

import java.util.Arrays;

public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    //二分查找，有重复值
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums.length == 0) return res;
        int left = 0;
        int right = nums.length - 1;
        //查找左边界
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                right = mid - 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        if(left >= nums.length || nums[left] != target){
            return res;
        }
        res[0] = left;
        left = 0;
        right = nums.length - 1;
        //查找右边界
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        // if(right <= 0 || nums[right] != target) return res;运行到这肯定有值不需要判断了
        res[1] = right;
        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return res;
        }
        res[0] = left;
        while (left < nums.length && nums[left] == target) {
            left++;
        }
        res[1] = left - 1;
        return res;
    }
}
