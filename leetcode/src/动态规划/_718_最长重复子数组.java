package 动态规划;

public class _718_最长重复子数组 {
    //以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //dp[i][j] 表示以nums1第i个和nums2第j个为结尾的最长子数组的长度。(从1开始。)
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
    //如果定义dp表示以下标i,下标j那么需要多出很多初始化步骤
    public int findLength2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //定义dp[i][j]为 以下标i为结尾的A，和以下标j 为结尾的B，最长重复子数组长度。
        int[][] dp = new int[m][n];
        // 要对第一行，第一列经行初始化
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums1[0] == nums2[j]) {
                dp[0][j] = 1;
                max = 1;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
