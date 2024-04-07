package 数组;

import java.util.HashMap;

public class LCR_011_连续数组 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == 0) {
                preSum[i] = preSum[i - 1] - 1;
            } else {
                preSum[i] = preSum[i - 1] + 1;
            }
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();//记录出现的值和其距离i位置最远的值的索引。
        map.put(preSum[0], 0);//初始化
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(preSum[i])) {
                res = Math.max(res, i - map.get(preSum[i]));
            } else {
                map.put(preSum[i], i);
            }
        }
        return res;
    }
}
