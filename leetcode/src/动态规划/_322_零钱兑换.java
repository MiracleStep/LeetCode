package 动态规划;

public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        //dp表示凑到i元的最小硬币数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin <= i && dp[i - coin] != -1 && dp[i - coin] < min){
                    min = dp[i - coin];
                }
            }
            if(min == Integer.MAX_VALUE){
                dp[i] = -1; // 找不开
            } else {
                dp[i] = min + 1; // 找的开。
            }
        }
        return dp[amount];
    }
}
