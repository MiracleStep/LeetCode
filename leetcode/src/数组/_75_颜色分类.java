package 数组;

public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int idx1 = 0, idx2 = n - 1;
        int cur = 0;
        while (cur <= idx2) {
            if (nums[cur] == 0) {
                int tmp = nums[idx1];
                nums[idx1++] = 0;
                nums[cur++] = tmp;
            } else if (nums[cur] == 2) {
                int tmp = nums[idx2];
                nums[idx2--] = 2;
                nums[cur] = tmp;
            } else {
                cur++;
            }
        }
    }
}
