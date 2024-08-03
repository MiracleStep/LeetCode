package 动态规划;

public class _70_爬楼梯 {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        //dp表示爬到i + 1阶楼梯的所有方法个数
        int[] dp = new int[n];
        //确定初始状态
        dp[0] = 1;
        dp[1] = 2;
        //确定状态转移方程
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
