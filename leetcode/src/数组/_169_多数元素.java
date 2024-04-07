package 数组;

import java.util.Arrays;

public class _169_多数元素 {
    //1.排序法
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //2.哈希表法：o(n)遍历，构建一个哈希表统计每个数的计数，o(n)空间复杂度

    //3.摩尔投票
    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
