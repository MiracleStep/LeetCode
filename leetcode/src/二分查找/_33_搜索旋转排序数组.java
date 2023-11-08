package 二分查找;

public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
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
