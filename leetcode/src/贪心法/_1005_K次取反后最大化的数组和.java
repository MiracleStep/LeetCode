package 贪心法;

import java.util.Arrays;

public class _1005_K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int minValue = Integer.MAX_VALUE;//记录最小的值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                //是负的就消耗k变正
                k--;
                nums[i] = -nums[i];
            }
            sum += nums[i];
            minValue = Math.min(minValue, nums[i]);
        }
        if (k % 2 == 1) {
            //对最小值变负，消耗掉k。如果是偶数说明可以对一个正数变k次，该正数不变
            sum -= minValue * 2;
        }
        return sum;
    }
}
