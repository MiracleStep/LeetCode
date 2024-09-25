package 动态规划;

public class _53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        //dp表示以i结尾的最大连续子数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(dp[i - 1] > 0){
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int res = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
