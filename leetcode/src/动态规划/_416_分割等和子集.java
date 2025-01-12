package 动态规划;

public class _416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        //转化为0-1背包问题
        //第i件物品可选时，容量为j时背包是否正好装满
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) {
                    //装不了
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //装的了：装 or 不装
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
            //剪枝，提前结束
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[nums.length][target];
    }
}
