package 数组;

import java.util.HashMap;
import java.util.Map;

public class LCR_010_和为K的子数组 {
    // 不能用滑动窗口因为有负数导致的后果是，窗口增大的时候，和不一定增大，违背了滑窗的性质
    // 使用前缀和
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < len; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                res += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
