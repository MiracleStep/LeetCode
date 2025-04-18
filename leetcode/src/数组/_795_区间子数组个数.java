package 数组;

public class _795_区间子数组个数 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int res = 0;
        int last1 = -1, last2 = -1;
        //2141243
        for (int j = 0; j < n; j++) {
            if (nums[j] >= left && nums[j] <= right) {
                last1 = j;
            } else if (nums[j] > right) {
                last2 = j;
            }
            if (last1 > last2) {
                res += last1 - last2;
            }
        }
        return res;
    }
}
