package 字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length() == 0) return 0;
        int left = 0;
        int len = 1;
        map.put(s.charAt(left), 0);
        for (int right = 1; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;//更新左指针，但要确保更新结果比左指针更大。
            } else {
                len = Math.max(len, right - left + 1);//更新结果
            }
            map.put(c, right);//更新哈希表
        }
        return len;
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
