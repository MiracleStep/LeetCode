package 串;

public class KMP {
    public static void main(String[] args) {
        System.out.println(indexOf("asdefjkas", "defj"));
    }

    public static int indexOf(String text, String pattern){
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (tlen < plen) return -1;

        int[] next = next(pattern);

        int pi = 0, ti = 0, lenDelta = tlen - plen;
        while (pi < plen && ti - pi <= lenDelta){
            if (pi < 0 || textChars[ti] == patternChars[pi]){
                ti++;
                pi++;
            } else {
                pi = next[pi];
            }
        }
        return (pi == plen) ? (ti - pi) : -1;
    }

    public static int[] next(String pattern){
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        next[0] = -1;
        int i = 0;
        int n = -1;
        int imax = chars.length - 1;
        while (i < imax){
            if (n < 0 || chars[i] == chars[n]){
                next[++i] = ++n;
            }else {
                n = next[n];
            }
        }
        return next;
    }
}
