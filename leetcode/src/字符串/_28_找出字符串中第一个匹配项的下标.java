package 字符串;

public class _28_找出字符串中第一个匹配项的下标 {
    public int strStr(String haystack, String needle) {
        return indexOf(haystack, needle);
    }

    private int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        int tlen = text.length(), plen = pattern.length();
        if (tlen == 0 || plen == 0 || tlen < plen) return -1;
        int pi = 0, ti = 0;
        int[] next = next(pattern);
        while (pi < plen && ti - pi <= tlen - plen) {
            if (pi < 0 || text.charAt(ti) == pattern.charAt(pi)) {
                ti++;
                pi++;
            } else {
                pi = next[pi];
            }
        }
        return pi == plen ? ti - pi : -1;
    }

    private int[] next(String pattern) {
        int len = pattern.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = 0, n = next[0];
        while (i + 1 < len) {
            if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }
        return next;
    }
}
