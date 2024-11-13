package 哈希;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _128_最长连续序列 {
    //最优解
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int count = 1;
            if (!set.contains(num + 1)) { //这个是最大的值了，没有比它更大的了
                while (set.contains(--num)) {
                    count++;
                }
            }
            res = Math.max(res, count);
        }

        return res;
    }

    public int longestConsecutive2(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int res = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                res = Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);
        return res;
    }
}
