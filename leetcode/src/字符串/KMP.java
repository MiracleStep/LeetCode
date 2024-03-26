package 字符串;

public class KMP {
    public static void main(String[] args) {
        int index = indexOf("hello", "ll");
        System.out.println(index);
    }
    //KMP主函数
    private static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        int tlen = text.length(), plen = pattern.length();
        if (tlen == 0 || plen == 0 || tlen < plen) return -1;
        int ti = 0, pi = 0;
        int[] next = next(pattern);//next数组
        while (pi < plen && ti - pi <= tlen - plen) { //ti - pi == 正常匹配text索引的初始位置
            if (pi < 0 || text.charAt(ti) == pattern.charAt(pi)) {
                ti++;
                pi++;
            } else {
                pi = next[pi];
            }
        }
        return pi == plen ? ti - pi : -1;
    }
    //构造next数组
    private static int[] next(String pattern) {
        int len = pattern.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = 0, n = next[0];
        while (i + 1 < len) {//当前求的是next[i + 1] 所以 i + 1 < len
            if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }
        return next;
    }
}
