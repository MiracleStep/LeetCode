package 数组;

public class _189_轮转数组 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            return;
        }
        if (k > n) {
            k %= n;
        }
        reverseNums(nums, 0, n - 1);
        reverseNums(nums, 0, k - 1);
        reverseNums(nums, k, n - 1);
    }

    private void reverseNums(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
