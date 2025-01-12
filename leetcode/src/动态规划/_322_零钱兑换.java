package 动态规划;

import java.util.Arrays;

public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        //总金额为i时的最小硬币数
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) { // 硬币的数量是无限。
                if (coin > i) {
                    //面额太大了，无法找。直接剪枝
                    break;
                } else if (dp[i - coin] != Integer.MAX_VALUE){
                    //用与不用
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    //最标准的写法
    public int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = amount + 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int coin = coins[i - 1];
                if (coin > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i - 1][j]);
                }
            }
        }
        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }
}
