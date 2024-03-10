package 动态规划;

public class _416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        //转化为0-1背包问题
        //第i件物品可选时，容量为j时背包是否正好装满
        boolean[][] dp = new boolean[nums.length][target + 1];
        //初始化
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;//直接拿第0件物品来装
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] > j) {
                    //装不了
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //装的了：装 or 不装
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
            //观察状态转移方程，or 的结果只要为真，表格 这一列 下面所有的值都为真。
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }
}
