package 回溯法;

import java.util.*;

public class _17_电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        int len = digits.length();
        List<String> res = new ArrayList<>();

        if(len == 0){
            return res;
        }
        char[] path = new char[len];
        dfs(digits, phoneMap, 0, len, path, res);
        return res;
    }

    public void dfs(String digits, Map<Character, String> phoneMap, int depth, int len, char[] path, List<String> res){
        if(depth == len){
            res.add(new String(path));
            return;
        }
        String curChars = phoneMap.get(digits.charAt(depth));
        for(int i = 0;i < curChars.length(); i++){
            path[depth] = curChars.charAt(i);
            depth++;
            dfs(digits, phoneMap, depth, len, path, res);
            depth--;
        }
    }
}
