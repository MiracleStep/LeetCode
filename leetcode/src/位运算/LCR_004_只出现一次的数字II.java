package 位运算;

import java.util.HashMap;
import java.util.Map;

public class LCR_004_只出现一次的数字II {
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> each : map.entrySet()) {
            if (each.getValue() == 1) {
                return each.getKey();
            }
        }
        return -1;
    }
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i <  32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
