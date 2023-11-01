package 数据结构专题;

import java.util.HashMap;

public class _1_两数之和 {
	public int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i<len;i++) {
			if(map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
    }
}
