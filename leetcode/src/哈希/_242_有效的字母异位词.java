package 哈希;

import java.util.Arrays;

public class _242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i : count){
            if(i != 0) return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        if (String.valueOf(sChars).equals(String.valueOf(tChars))) return true;
        return false;
    }
}
