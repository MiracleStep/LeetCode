package 字符串;

import java.util.HashMap;
import java.util.Map;

public class LCR_017_最小覆盖子串 {
    public static void main(String[] args) {
        new LCR_017_最小覆盖子串().minWindow("ADOBECODEBANC", "ABC");
    }
    //自己写的，滑动窗口 + 哈希表
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        String res = "";
        int count = map.size();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                int curNum = map.get(cur) - 1;
                map.put(cur, curNum);
                if (curNum == 0) {
                    count--;
                }
                while (!map.containsKey(s.charAt(left)) || map.get(s.charAt(left)) < 0) {
                    //收缩左边界，直到左边界字符会造成map对应的key的值大于0 或者 不是我们需要的字符。
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    }
                    left++;
                }
                if (count == 0 && (res.equals("") || res.length() > i - left + 1)) {
                    //这种解法，只要满足count == 0 就会一直满足，因为上面while就是不影响map的对应值大于0.
                    res = s.substring(left, i + 1);
                }
            }
        }
        return res;
    }

    //自己写的，滑动窗口 + 哈希表
    public String minWindow2(String s, String t) {
        int[] tCount = new int[60];
        int[] sCount = new int[60];
        int charCount = 0; //s的子串需要覆盖的字符数
        for (int i = 0; i < t.length(); i++) {
            if (++tCount[t.charAt(i) - 'A'] == 1) charCount++;
        }
        String res = "";
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int ridx = s.charAt(i) - 'A';
            sCount[ridx]++;
            if (sCount[ridx] == tCount[ridx]) {
                //一个字符满足包含了。
                charCount--;
            }
            int lidx = s.charAt(left) - 'A';
            while (left < i && sCount[lidx] > tCount[lidx]) {
                //左边存在冗余的字母，需要收缩滑动窗口
                sCount[lidx]--;
                left++;
                lidx = s.charAt(left) - 'A';
            }
            if (charCount == 0 && (res.equals("") || res.length() > i - left + 1)) {
                //这种解法，只要满足count == 0 就会一直满足，因为上面while就是始终让值sCount[idx] >= tCount[idx]
                res = s.substring(left, i + 1);
            }
        }
        return res;
    }
}
