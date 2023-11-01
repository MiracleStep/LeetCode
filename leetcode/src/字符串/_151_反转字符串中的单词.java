package 字符串;

public class _151_反转字符串中的单词 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for (int right = s.length() - 1; right >= 0; right--){
            if (s.charAt(right) != ' '){
                int left;
                for (left = right; left >= 0;){
                    if (s.charAt(left) != ' '){
                        left--;
                    } else {
                        break;
                    }
                }
                sb.append(s, left+1, right+1);
                sb.append(' ');
                right = left;
            }
        }
        sb.deleteCharAt(sb.length() - 1); //删除最后一个单词后的空格
        return sb.toString();
    }
}
