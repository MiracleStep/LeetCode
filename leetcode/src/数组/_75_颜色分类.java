package 数组;

public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        if (nums.length == 1) return;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                if (p0 < p1) {  //当 p0 < p1 此时交换已经把1交换出去了，因此再交换回来到p1位置
                    nums[i] = nums[p1];
                    nums[p1] = 1;
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                nums[i] = nums[p1];
                nums[p1] = 1;
                p1++;
            }
        }
    }
}
