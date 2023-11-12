package 二分查找;

public class _81_搜索旋转排序数组II {

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return false;
        if(n == 1){
            return nums[0] == target ? true : false;
        }
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            //先判断mid节点是否是要找的
            if(nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                //收缩区间
                left++;
                right--;
            } else if(nums[left] <= nums[mid]){
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
        return false;
    }

    public boolean search2(int[] nums, int target) {
        if (nums == null) return false;
        int n = nums.length;
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                minIndex = i;
                break; //找到第一个最小的值。
            }
        }

        int left = minIndex;
        int right = n + minIndex - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid % n] < target) {
                left = mid + 1;
            } else if (nums[mid % n] > target) {
                right = mid - 1;
            } else if (nums[mid % n] == target) {
                return true;
            }
        }
        return false;
    }
}
