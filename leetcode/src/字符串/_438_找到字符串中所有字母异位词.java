package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return list;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            list.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - pLen) - 'a']--;

            if (Arrays.equals(sCount, pCount)) {
                list.add(i - pLen + 1);
            }
        }
        return list;
    }
}
