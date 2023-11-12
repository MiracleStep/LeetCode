package 二分查找;

public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        if(n == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            //先判断mid节点是否是要找的
            if(nums[mid] == target){
                return mid;
            }
            //再找那边是有序的（总有一边是有序的）
            if(nums[left] <= nums[mid]){
                //左边是有序的
                if(nums[left] <= target && target < nums[mid]){
                    //target在左边
                    right = mid - 1;//收缩右边界
                } else {
                    //target在右边
                    left = mid + 1; //收缩左边界
                }
            } else {
                //右边是有序的
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    //另一种方法
    public int search2(int[] nums, int target) {
        int n = nums.length;
        int k = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                k = i;
            }
        }
        int left = k;
        int right = n + k - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid % n] > target) {
                right = mid - 1;
            } else if (nums[mid % n] == target) {
                return mid % n;
            } else if (nums[mid % n] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


}
