package 字符串;

public class _541_反转字符串II {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();
        boolean flag = true;
        for(int i = 0; i < len; i += k){
            if (i + k > len){
                if (flag){
                    for(int left = i, right = len - 1; left < right; left++, right--){
                        reverseStr(chars, left, right);
                    }
                    break;
                } else {
                    break;
                }
            } else {
                if (flag){
                    for(int left = i, right = i + k - 1; left < right; left++, right--){
                        reverseStr(chars, left, right);
                    }
                    flag = false;
                }else{
                    flag = true;
                }
            }
        }

        return new String(chars);
    }

    private void reverseStr(char[] chars, int left, int right){
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }

    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();
        boolean flag = true;
        for(int i = 0; i < len; i += 2*k){//步长2*k
            reverseString2(chars, i, Math.min(i+k, len) - 1);
        }
        return String.valueOf(chars);
    }

    //翻转数组
    public void reverseString2(char[] s,int left,int right) {
        //左右双指针
        while(left<right){
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            //移动指针
            left++;
            right--;
        }
    }
}
