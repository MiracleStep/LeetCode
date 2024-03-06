package 动态规划;

public class _152_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        //dp表示以i为结尾的，j=0表示乘积最大值，j=1表示乘积最小值
        int[][] dp = new int[nums.length][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= 0){
                //和乘积最大值相乘比较
                dp[i][0] = Math.max(dp[i-1][0] * nums[i], nums[i]);
                //和乘积最小值相乘比较
                dp[i][1] = Math.min(dp[i-1][1] * nums[i], nums[i]);
            } else {
                //和乘积最大值相乘比较
                dp[i][0] = Math.max(dp[i-1][1] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i-1][0] * nums[i], nums[i]);
            }

            res = Math.max(res, dp[i][0]);
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        //以i结尾的的非空连续子数组,dp[i][0]乘积最大，dp[i][1]乘积最小
        int maxNum = nums[0], minNum = nums[0];
        int res = maxNum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxNum = Math.max(maxNum * nums[i], nums[i]);
                minNum = Math.min(minNum * nums[i], nums[i]);
            } else {
                int tmpMaxNum = maxNum, tmpMinNum = minNum;
                maxNum = Math.max(tmpMinNum * nums[i], nums[i]);
                minNum = Math.min(tmpMaxNum * nums[i], nums[i]);
            }
            res = Math.max(maxNum, res);
        }
        return res;
    }
}
