package 字符串;

public class _125_验证回文串 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);
            if (!Character.isLetterOrDigit(lChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rChar)) {
                right--;
            } else {
                if (Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
