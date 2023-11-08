package 数论;

public class _50_Pow_x_n {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long b = n;
        if (n < 0) { //n为负数，变为1/x相乘。
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) ans *= x;
            x *= x; //分别表示原始
            b >>= 1;
        }
        return ans;
    }
}
