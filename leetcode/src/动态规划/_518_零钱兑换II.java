package 动态规划;

/**
 * @author Mirac
 * @date 8/10/2024
 */
public class _518_零钱兑换II {
    public int change(int amount, int[] coins) {
        //定义 `dp[i][j]` 为考虑前 i 件物品，凑成总和为 j 的硬币组合数。
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int coin = coins[i - 1];
                if (coin > j) {
                    //不使用当前硬币
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //不使用当前硬币 和 使用当前硬币 的和。
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                }
            }
        }
        return dp[coins.length][amount];
    }

    //一维数组优化
    public int change2(int amount, int[] coins) {
        //一维数组优化
        //定义 `dp[i][j]` 为考虑前 i 件物品，凑成总和为 j 的硬币组合数。
        int[] dp = new int[amount + 1];

        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int coin = coins[i - 1];
                if (coin > j) {
                    //不使用当前硬币
                    dp[j] = dp[j];
                } else {
                    //不使用当前硬币 和 使用当前硬币 的和。
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }
}
