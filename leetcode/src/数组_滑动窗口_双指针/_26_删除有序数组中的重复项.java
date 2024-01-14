package 数组_滑动窗口_双指针;

public class _26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[slow + 1] = nums[fast];
                slow ++;
            }
        }
        return slow + 1;
    }
}
