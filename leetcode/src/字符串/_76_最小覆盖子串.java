package 字符串;

public class _76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        int[] tCount = new int[60];
        int[] sCount = new int[60];
        int charCount = 0; //s的子串需要覆盖的字符数
        for (int i = 0; i < t.length(); i++) {
            if (++tCount[getIdx(t.charAt(i))] == 1) charCount++;
        }
        String res = "";
        for (int i = 0, j = 0; i < s.length(); i++) {
            int ridx = getIdx(s.charAt(i)); //得到滑动窗口右边的字母索引
            sCount[ridx]++;
            if (sCount[ridx] == tCount[ridx]) {
                charCount--;
            }
            int lidx = getIdx(s.charAt(j));
            while(j < i && sCount[lidx] > tCount[lidx]) { //左边存在冗余的字母，需要收缩滑动窗口
                sCount[lidx]--;
                j++;
                lidx = getIdx(s.charAt(j)); //可能存在越界，需要j < i 判断一下
            }
            if (charCount == 0 && (res.length() == 0 || res.length() > i - j + 1)) {
                res = s.substring(j, i + 1);
            }
        }
        return res;
    }

    int getIdx(char x) {
        return x >= 'A' && x <= 'Z' ? x - 'A' + 26 : x - 'a';
    }
}
