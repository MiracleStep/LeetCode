package 贪心法;

public class _53_最大子数组和 {
    //贪心：找局部最大和的连续子数组，得到全局的最大连续子数组的和。
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
