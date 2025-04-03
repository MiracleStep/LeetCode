package 数组;

public class _209_长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                while (left < i && sum - nums[left] >= target) {
                    sum -= nums[left++];
                }
                res = Math.min(i - left + 1, res);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
