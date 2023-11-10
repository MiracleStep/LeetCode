package 二分查找;

public class _81_搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
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
