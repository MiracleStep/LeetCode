package 数论;

public class LCR_001_两数相除 {
    public int divide(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (a == Integer.MIN_VALUE && b == -1) { //边界条件，可能出现越界
            return Integer.MAX_VALUE;
        }
        boolean sign = (a > 0 && b > 0) || (a < 0 && b < 0);//计算符号
        a = a < 0 ? a : -a;//转化为符号，因为如果都转化为正号，那么-2^31无法用Integer的正数2^31表示(最大2^31-1)
        b = b < 0 ? b : -b;
        int ans = 0;//返回结果
        while (a <= b) {//除的了(负数)
            int cnt = 1;
            int x = b;
            while (x >= (Integer.MIN_VALUE >> 1) && a <= (x << 1)) {
                x += x;
                cnt += cnt;
            }
            a -= x;
            ans += cnt;
        }
        return sign ? ans : -ans;
    }
}
