public class Main {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 5;

        double ans = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) ans *= x;
            x *= x;
            n >>= 1;
        }
        System.out.println(ans);
    }
}
