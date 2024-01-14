package 数组_滑动窗口_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {

    public static void main(String[] args) {
        new _15_三数之和().threeSum(new int[]{0, 0, 0, 0});
    }

    //双指针
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//排序，避免重复，这样后面的值一定等于前面两个值和的负数。
        List<List<Integer>> list = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) { // 双指针，另两个值在k的右边
            if (nums[k] > 0) return list;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return list;
    }
}
