package 字符串;

import java.util.ArrayList;
import java.util.List;

public class LCR_015_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] counts = new int[26];
        for (int i = 0; i < m; i++) {
            counts[p.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'a';
            counts[x]++;
            while (counts[x] > 0) {
                counts[s.charAt(left++) - 'a']--;
            }
            if (i - left + 1 == m) {
                res.add(left);
            }
        }
        return res;
    }
}
