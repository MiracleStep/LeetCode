package 动态规划;

public class _213_打家劫舍II {
    public int rob(int[] nums) {
        //到达第i个房屋偷窃的最大金额(不一定偷第i个房屋)
        if(nums.length == 1){
            return nums[0];
        }
        int leftVal = robRange(nums, 0, nums.length - 1);
        int rightVal = robRange(nums, 1, nums.length);
        return Math.max(leftVal, rightVal);
    }

    private int robRange(int[] nums, int start, int end){
        int[] dp = new int[end - start + 1];
        dp[1] = nums[start];
        for(int i = 2; i <= end - start; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start + i - 1]);
        }
        return dp[end - start];
    }
}
