package 动态规划;

public class 最大连续子序列的和 {
    public static void main(String[] args) {
        System.out.println(new 最大连续子序列的和().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
