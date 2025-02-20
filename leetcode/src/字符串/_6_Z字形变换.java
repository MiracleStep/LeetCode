package 字符串;

public class _6_Z字形变换 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int idx = 0;
        int val = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sbs[idx].append(c);
            if (idx == 0) {
                val = 1;
            } else if (idx == numRows - 1) {
                val = -1;
            }
            idx += val;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) {
            res.append(sb);
        }
        return res.toString();
    }}
