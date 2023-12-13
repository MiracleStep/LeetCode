package 动态规划;

public class _674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        //以i为结尾的最长连续子序列的长度
        // int[] dp = new int[nums.length];
        int count = 1;
        // dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                count ++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
