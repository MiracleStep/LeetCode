package 位运算;

import java.util.Arrays;

public class _136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }
    public int singleNumber2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int count = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i]) {
                count--;
            } else if (count == 1){
                return pre;
            } else {
                count = 1;
                pre = nums[i];
            }
        }
        return count == 1 ? pre : -1;
    }
}
