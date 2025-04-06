package 哈希;

import java.util.HashMap;
import java.util.Map;

public class _205_同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if ((s2t.containsKey(sc) && s2t.get(sc) != tc) || (t2s.containsKey(tc) && t2s.get(tc) != sc)) {
                return false;
            }
            s2t.put(sc, tc);
            t2s.put(tc, sc);
        }
        return true;
    }}
