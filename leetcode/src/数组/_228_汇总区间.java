package 数组;

import java.util.ArrayList;
import java.util.List;

public class _228_汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        int left = 0;
        for (int right = 1; right < n; right++) {
            if (nums[right] != nums[right - 1] + 1) {
                if (left == right - 1) {
                    res.add(nums[left]+"");
                } else {
                    res.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;
            }
        }
        if (left < n) {
            if (left == n - 1) {
                res.add(nums[left]+"");
            } else {
                res.add(nums[left] + "->" + nums[n - 1]);
            }
        }
        return res;
    }
}
