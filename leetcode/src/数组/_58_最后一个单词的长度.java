package 数组;

public class _58_最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        for (int right = len - 1; right >= 0; right--) {
            char cur = s.charAt(right);
            if (isChar(cur)) {
                int left = right;
                while (left >= 0 && isChar(s.charAt(left))) {
                    left--;
                }
                return right - left;
            }
        }
        return 0;
    }
    private boolean isChar(char cur) {
        return ((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z'));
    }}
