package 动态规划;

public class _45_跳跃游戏II {
    //动态规划
    public int jump(int[] nums) {
        //确定状态：定义dp[i]为到达第 i 个位置所需要的最小步数 。
        int[] dp = new int[nums.length];
        //确定初始状态
        dp[0] = 0;
        //确定状态转移方程
        int j = 0;//记录到达i位置的最远的点
        for (int i = 1; i < nums.length; i++) {
            while (j + nums[j] < i) {
                j++;
            }
            //dp[j] <= dp[j+1]是肯定成立的，所以只要找到可以到达dp[i]的第一个dp[j]即可。
            dp[i] = dp[j] + 1;
        }
        return dp[nums.length - 1];
    }

    //动态规划，时间复杂度高
    public int jump2(int[] nums) {
        //确定状态：定义dp[i]为到达第 i 个位置所需要的最小步数 。
        int[] dp = new int[nums.length];
        //确定初始状态
        dp[0] = 0;
        //确定状态转移方程
        for(int i = 1; i < nums.length; i++){
            int minStep = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i){
                    //j处能够到达i处
                    minStep = Math.min(minStep, dp[j]);
                }
            }
            dp[i] = minStep + 1;
        }
        return dp[nums.length - 1];
    }
}
