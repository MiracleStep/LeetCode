package 哈希;

import java.util.*;

public class _01_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            hashMap.put(nums[i], i);
        }
        int targetIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) && (targetIndex = hashMap.get(target - nums[i])) != i){
                return new int[]{i, targetIndex};
            }
        }
        return null;
    }

    //优化
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
