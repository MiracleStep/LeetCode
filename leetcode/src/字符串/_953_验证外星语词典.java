package 字符串;

public class _953_验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        if (words.length == 1) {
            return true;
        }
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String left = words[i - 1];
            String right = words[i];
            boolean flag = true;//是否进行查看长度判断
            for (int j = 0; j < left.length() && j < right.length(); j++) {
                int lefti = index[left.charAt(j) - 'a'];
                int righti = index[right.charAt(j) - 'a'];
                if (lefti < righti) {
                    flag = false;//有一个小，直接跳出
                    break;
                } else if (lefti > righti) {
                    return false;//有一个大直接结束
                }
            }
            if (flag && left.length() > right.length()) {
                return false;
            }
        }
        return true;
    }
}
