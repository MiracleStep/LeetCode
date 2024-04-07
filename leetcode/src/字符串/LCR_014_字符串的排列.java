package 字符串;

import java.util.Arrays;

public class LCR_014_字符串的排列 {
    //固定窗口长度的滑动窗口
    public boolean checkInclusion(String s1, String s2) {
        int[] target = new int[26];//统计s1 target
        int[] counts = new int[26];//当前统计s2
        int n = s1.length(), m = s2.length();
        if (m < n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            target[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(target, counts)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            counts[s2.charAt(i) - 'a']++;
            counts[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(counts, target)) {
                return true;
            }
        }
        return false;
    }

    //非固定窗口长度的滑动窗口
    public boolean checkInclusion2(String s1, String s2) {
        int[] counts = new int[26];
        int n = s1.length(), m = s2.length();
        if (m < n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            counts[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int right = 0; right < m; right++) {
            int x = s2.charAt(right) - 'a';
            counts[x]++;
            while (counts[x] > 0) {
                counts[s2.charAt(left++) - 'a']--;
            }
            if (right - left + 1 == n) {
                //如果长度满足就一定成功
                return true;
            }
        }
        return false;
    }
}
