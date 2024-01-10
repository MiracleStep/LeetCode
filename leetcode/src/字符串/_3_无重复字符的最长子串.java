package 字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0, i = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));//更新左指针，但要确保更新结果比左指针更大。
            }
            map.put(s.charAt(j), j);//更新哈希表
            res = Math.max(res, j - i);//更新结果
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int res = 1;
        //dp[i]表示以s[i]为结尾的最长子串的长度。
        int dp[] = new int[len];
        Map<Character, Integer> map = new HashMap<>();
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        for (int j = 1; j < len; j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);//更新哈希表
            int count = j - i;
            if (dp[j - 1] < count) {//说明字符 s[i]在子字符串 dp[j−1]区间之外
                dp[j] = dp[j - 1] + 1;
            } else {
                dp[j] = count;
            }
            res = Math.max(dp[j], res);
        }
        return res;
    }
}
