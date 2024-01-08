package 哈希;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _128_最长连续序列 {
    //最优解
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                //最小的数了。
                int curNum = num;
                int count = 1;
                while (set.contains(curNum + 1)) {
                    count++;
                    curNum++;
                }
                res = Math.max(res, count);
            }
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
