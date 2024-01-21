package 哈希;

public class _41_缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        //原地哈希 哈希函数hash(nums[i]) = nums[i] - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] - 1 < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        //重新遍历，找
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
