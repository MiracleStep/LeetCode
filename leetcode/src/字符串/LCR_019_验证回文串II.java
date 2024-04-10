package 字符串;

public class LCR_019_验证回文串II {
    public static void main(String[] args) {
        new LCR_019_验证回文串II().validPalindrome("ebcbbececabbacecbbcbe");
    }
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        //"abbca"
        boolean flag = true;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return valid(s, left + 1, right) || valid(s, left, right - 1);
            }
        }
        return true;
    }

    public boolean valid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
