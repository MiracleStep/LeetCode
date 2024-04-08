package 字符串;

import java.util.HashMap;
import java.util.Map;

public class LCR_016_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
