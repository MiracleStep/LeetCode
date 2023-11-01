package 数据结构专题;

import java.util.Arrays;

public class _242_有效的字母异位词 {
	public boolean isAnagram(String s, String t) {
		int[] sa = new int[26];
		int[] ta = new int[26];
		for(int i = 0;i<s.length();i++) {
			sa[s.charAt(i)-'a'] += 1;
		}
		
		for(int j = 0;j<t.length();j++) {
			ta[t.charAt(j)-'a'] += 1;
		}
		
		if(Arrays.equals(sa, ta)) {
			return true;
		}
		return false;
    }
}
