package 数组;

public class LCR_009_乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) {//特殊情况
            return 0;
        }
        int muls = 1;
        int left = 0;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            muls *= nums[right];
            if (muls < k) {
                //以[left, right]区间并且以right结尾的子数组都满足小于
                res += right - left + 1;
            } else {
                //以[left, right]区间不满足小于，先变成小于的
                while (muls >= k) {
                    //除走
                    muls /= nums[left++];
                }
                //以[left, right]区间并且以right结尾的子数组都满足小于
                res += right - left + 1;//如果全都不满足，那么left == right - 1此时res += 0.
            }
        }
        return res;
    }
}
