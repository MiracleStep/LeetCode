package 数组_滑动窗口_双指针;

public class _80_删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int count = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                count = 1;
                nums[slow + 1] = nums[fast];
                slow++;
            } else if (nums[fast] == nums[slow] && count == 1) {
                count = 2;
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return slow + 1;
    }
}
