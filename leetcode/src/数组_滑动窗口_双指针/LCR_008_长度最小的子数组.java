package 数组_滑动窗口_双指针;

public class LCR_008_长度最小的子数组 {
    public static void main(String[] args) {
        new LCR_008_长度最小的子数组().minSubArrayLen2(7, new int[]{2,3,1,2,4,3});
    }
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    //前缀和 + 二分搜索  虽然时间复杂度是o(n logn)但是确实是一个有用的解法。
    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            int bTarget = sum[i] - target;
            int left = 0, right = i - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (sum[mid] <= bTarget) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (right >= 0 && sum[right] <= bTarget) ans = Math.min(ans, i - right);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
