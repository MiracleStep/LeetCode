package 数组;

import java.util.HashMap;

public class LCR_010_和为K的子数组 {
    // 不能用滑动窗口因为有负数导致的后果是，窗口增大的时候，和不一定增大，违背了滑窗的性质
    // 使用前缀和
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//记录出现的值和出现的次数
        for (int i = 1; i <= n; i++) {//以i - 1为结尾的连续子数组
            //和LCR008相似，但数组不连续无法用二分搜索,但因为是精确查找可以用hashmap来优化
            int target = sum[i] - k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return res;
    }
}
