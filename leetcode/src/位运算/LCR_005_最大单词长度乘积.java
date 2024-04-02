package 位运算;

public class LCR_005_最大单词长度乘积 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] counts = new int[n];
        int index = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                counts[index] |= 1 << (cur - 'a');
            }
            index++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((counts[i] & counts[j]) == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }
}
