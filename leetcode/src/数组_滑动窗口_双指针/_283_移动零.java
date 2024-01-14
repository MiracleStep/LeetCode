package 数组_滑动窗口_双指针;

public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        for(;slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
