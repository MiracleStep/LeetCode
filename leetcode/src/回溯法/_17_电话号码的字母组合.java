package 回溯法;

import java.util.*;

public class _17_电话号码的字母组合 {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        dfs(digits, map, sb, 0);
        return res;
    }

    private void dfs(String digits, HashMap<Character, String> map, StringBuilder sb, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(digits, map, sb, index + 1);
            sb.deleteCharAt(index);
        }
    }
}
