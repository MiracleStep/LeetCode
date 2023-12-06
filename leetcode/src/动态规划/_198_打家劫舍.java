package 动态规划;

public class _198_打家劫舍 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        //到达第i个房间能获取的最大利润（i从1开始。）
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int preMax = 0;
        for(int i = 2; i <= nums.length; i++){
            //偷与不偷
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[nums.length];
    }
}
