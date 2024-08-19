package 动态规划;

public class _300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        //以i为结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && dp[j] >= dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //时间复杂度最优
    public int lengthOfLIS2(int[] nums) {
        //tails[i]表示长度为i + 1的子序列尾部的最小元素
        int[] tails = new int[nums.length];
        int len = 0;
        tails[len++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[len - 1]) {
                //大于数组最后一个元素
                tails[len++] = nums[i];
            } else if (nums[i] < tails[len - 1]) {
                //小于数组最后一个元素，那肯定可以替换掉数组中某个元素
                //采用二分查找
                int left = 0;
                int right = len - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (tails[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                tails[left] = nums[i];
            }
        }
        return len;
    }
}
