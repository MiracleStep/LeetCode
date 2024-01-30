package 字符串;

import java.util.Scanner;

public class _541_反转字符串II {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i += (2 * k)) {
            int start = i;
            int end = Math.min(i + k - 1, s.length() - 1);
            while (start < end) {
                char tmp = ch[start];
                ch[start] = ch[end];
                ch[end] = tmp;
                end--;
                start++;
            }
        }
        return new String(ch);
    }
}
