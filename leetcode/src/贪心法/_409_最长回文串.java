package 贪心法;

import java.util.*;

public class _409_最长回文串 {
    public int longestPalindrome(String s) {
        //哈希表+贪心
        //数据结构可以采用hashMap也可以采用数组new int[26];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < s.length(); i++){
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }

        int res = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            Integer count = entry.getValue();
            res += count/2 * 2;//取值的偶数向下取整
            if(res % 2 == 0 && count % 2 == 1){
                //当前回文串长度为偶数，中间可以加一个字符
                res++;
            }
        }
        return res;
    }
}
