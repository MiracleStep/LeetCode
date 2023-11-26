package 动态规划;

public class _55_跳跃游戏 {
    //dp优化，这道题可以定义dp[i]表示为从i位置跳跃最远位置。
    public boolean canJump(int[] nums) {
        int maxArrive = 0 + nums[0];
        for(int i = 1; i < nums.length; i++){
            if(maxArrive >= nums.length)return true;
            if(maxArrive >= i){
                maxArrive = Math.max(maxArrive, nums[i] + i);
            } else {
                return false;
            }
        }
        return true;
    }
}
