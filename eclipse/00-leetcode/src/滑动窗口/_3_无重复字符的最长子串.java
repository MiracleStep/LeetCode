package 滑动窗口;

import java.util.HashMap;

public class _3_无重复字符的最长子串 {
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		
		if(len == 0||len == 1) {
			return len;
		}
		HashMap<Character,Integer> map = new HashMap<>();
		
		int left = 0;
		int max = 0;
		for(int j = 0;j < len;j++) {
			if(map.containsKey(s.charAt(j))) {
				left = Math.max(left,map.get(s.charAt(j))+ 1) ;
			}
			map.put(s.charAt(j),j);
			max = Math.max(max,j-left+1);
		}
		return max;
    }
}
