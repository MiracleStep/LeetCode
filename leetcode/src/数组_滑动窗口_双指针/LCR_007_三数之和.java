package 数组_滑动窗口_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR_007_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    while (j < --k  && nums[k] == nums[k + 1]);
                } else if (sum < 0) {
                    while (++j < k && nums[j] == nums[j - 1]);
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < --k  && nums[k] == nums[k + 1]);
                    while (++j < k && nums[j] == nums[j - 1]);
                }
            }
        }
        return res;
    }
}
