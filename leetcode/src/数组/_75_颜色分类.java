package 数组;

public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        if (nums.length == 1) return;
        int i = 0;
        int p0 = 0, p2 = nums.length;
        while (i < p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, --p2);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
