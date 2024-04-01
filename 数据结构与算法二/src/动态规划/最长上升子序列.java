package 动态规划;

public class 最长上升子序列 {
    public static void main(String[] args) {
        System.out.println(new 最长上升子序列().lengthOfLIS2(new int[]{10, 2, 2, 5, 1, 7, 101, 18}));
    }
    int lengthOfLIS(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //二分查找实现
    int lengthOfLIS2(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int len = 0;
        int[] top = new int[nums.length];

        for (int num : nums) {
            int begin = 0;
            int end = len - 1;
            while (begin <= end){
                int mid = (begin + end) >> 1;
                if (top[mid] < num){
                    begin = mid + 1;
                }else if(top[mid] >= num){
                    end = mid - 1;
                }
            }
            top[begin] = num;
            if (begin == len) len++;
        }
        return len;
    }
}
