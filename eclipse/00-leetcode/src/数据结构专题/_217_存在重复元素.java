package 数据结构专题;

import java.util.HashSet;

public class _217_存在重复元素 {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set  = new HashSet<>();
		for(int i = 0;i<nums.length;i++) {
			boolean contains = set.add(nums[i]);
			if(!contains) {
				return !contains;
			}
		}
		return false;
    }
}
