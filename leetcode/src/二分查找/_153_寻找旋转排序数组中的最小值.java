package 二分查找;

public class _153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int minNum = Integer.MAX_VALUE;
        int left = 0,right = n - 1;
        //目标也就是target就是找最小的。
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < minNum){
                minNum = nums[mid];
            }
            //找那边有序
            if(nums[left] <= nums[mid]){
                //左边有序,最左边就是最小的
                if(nums[left] < minNum){
                    minNum = nums[left];
                }
                left = mid + 1;//再去右边找
            } else {
                //右边有序，最左边就是最小的
                if(nums[mid + 1] < minNum){
                    minNum = nums[mid + 1];
                }
                right = mid - 1;//再去左边找
            }
        }
        return minNum;
    }
}
