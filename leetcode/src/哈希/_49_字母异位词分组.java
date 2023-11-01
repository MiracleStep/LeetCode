package 哈希;

import java.util.*;
import java.util.stream.Collectors;

public class _49_字母异位词分组 {
    public static void main(String[] args) {
        new _49_字母异位词分组().groupAnagrams2(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    // 排序解决，不同字母异位词排序后相等。*
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    // 计数：bbdaaa -> a3b2d1 扔到哈希表匹配
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int[] count = null;
        for (String str : strs) {
            char[] array = str.toCharArray();
            count = new int[26];
            for (int i = 0; i < array.length; i++){
                count[array[i] - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++){
                if (count[i] != 0){
                    stringBuilder.append((char)('a'+i));
                    stringBuilder.append(count[i]);
                }
            }
            String key = stringBuilder.toString();
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
