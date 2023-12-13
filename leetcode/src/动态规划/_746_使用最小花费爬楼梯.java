package 动态规划;

public class _746_使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //爬上i阶所需要支付的最小费用
        int[] dp = new int[n];
        for(int i = 2; i < n; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return Math.min(dp[n-1]+cost[n-1],dp[n-2]+cost[n-2]);
    }
}
