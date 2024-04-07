package 数组;

public class LCR_012_寻找数组的中心下标 {
    //前缀和
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int target = preSum[i];
            if (preSum[n] - preSum[i] - nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
