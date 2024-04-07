package 数组;

import java.util.HashMap;
import java.util.Map;

public class _560_和为K的子数组 {
    //前缀和+哈希表 最优
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];//计算前缀和
            if (map.containsKey(preSum - k)) { // 查看是否有符合要求的前缀和
                res += map.get(preSum - k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }

    //前缀和
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1]; //定义前缀和数组
        preSum[0] = nums[0];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];//计算前缀和
        }
        int res = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) { //要一个一个的匹配，因此增加一个哈希表进行记录
                if (preSum[right + 1] - preSum[left] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
