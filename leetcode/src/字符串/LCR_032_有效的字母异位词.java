package 字符串;

import java.util.Arrays;

public class LCR_032_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();
        if(m != n) return false;
        if(s.equals(t)) return false;//这里有个特殊样例，相等判断为非变位词
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(char c : s.toCharArray()) cnt1[c - 'a']++;
        for(char c : t.toCharArray()) cnt2[c - 'a']++;
        return Arrays.equals(cnt1, cnt2);
    }
}
