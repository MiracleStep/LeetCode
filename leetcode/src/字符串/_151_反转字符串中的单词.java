package 字符串;

public class _151_反转字符串中的单词 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                int start = i;
                while (start >= 0 && s.charAt(start) != ' ') {
                    start--;
                }
                sb.append(s.substring(start + 1, i + 1));
                sb.append(" ");
                i = start + 1;
            }
        }

        return sb.substring(0, sb.length() - 1);
    }
}
