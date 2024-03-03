package 动态规划;

public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];//定义dp[i]表示为从i位置跳跃最远位置。
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= i) {
                dp[i] = Math.max(dp[i - 1], nums[i] + i);
            } else {
                return false;
            }
            if (dp[i] >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }

    //dp优化，这道题可以定义dp[i]表示为从i位置跳跃最远位置。
    public boolean canJump2(int[] nums) {
        int maxArrive = 0 + nums[0];
        for(int i = 1; i < nums.length; i++){
            if(maxArrive >= nums.length - 1)return true;
            if(maxArrive >= i){
                maxArrive = Math.max(maxArrive, nums[i] + i);
            } else {
                return false;
            }
        }
        return true;
    }


}
