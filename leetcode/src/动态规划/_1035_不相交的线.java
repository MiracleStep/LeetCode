package 动态规划;

public class _1035_不相交的线 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //这是一道最长公共子序列的题
        //以i-1，j-1为结尾的子数组的最长公共子序列的长度
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int i = 1; i <= nums1.length; i++){
            for(int j = 1; j <= nums2.length; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
