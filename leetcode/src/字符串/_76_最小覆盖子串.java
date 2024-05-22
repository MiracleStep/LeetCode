package 字符串;

public class _76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        int[] tCount = new int[60];
        int[] sCount = new int[60];
        int charCount = 0; //s的子串需要覆盖的不同字符数
        for (int i = 0; i < t.length(); i++) {
            if (++tCount[t.charAt(i) - 'A'] == 1) charCount++;
        }
        String res = "";
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int ridx = s.charAt(i) - 'A'; //得到滑动窗口右边的字符索引
            sCount[ridx]++;
            if (sCount[ridx] == tCount[ridx]) {
                charCount--;
            }
            if (charCount == 0) { //当前子串已经满足覆盖了
                int lidx = s.charAt(left) - 'A';
                while(left < i && sCount[lidx] > tCount[lidx]) { //左边存在冗余的字母，需要收缩滑动窗口
                    sCount[lidx]--;
                    left++;
                    lidx = s.charAt(left) - 'A'; //可能存在越界，需要left < i 判断一下
                }
                if (res.length() == 0 || res.length() > i - left + 1) {
                    res = s.substring(left, i + 1);
                }
            }
        }
        return res;
    }
}
