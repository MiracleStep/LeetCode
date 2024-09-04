package 动态规划;

public class _416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        if (nums.length == 0) return true;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        //第i件物品可选时，容量为j时背包是否正好装满
        boolean[][] dp = new boolean[nums.length][target + 1];
        //初始化
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] <= j) {
                    //装得下
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    //装不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
