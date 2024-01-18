package 数组_滑动窗口_双指针;

public class _189_轮转数组 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(k > len) {
            k %= len;
        }
        reverse(nums, 0, len);
        reverse(nums, k, len);
        reverse(nums, 0, k);
    }

    //旋转数组
    private void reverse(int[] nums, int start, int end) {
        end--;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
