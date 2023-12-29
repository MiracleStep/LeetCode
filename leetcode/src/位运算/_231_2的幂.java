package 位运算;

public class _231_2的幂 {
    public boolean isPowerOfTwo(int n) {
        if(n > 0){
            return (n & (n - 1)) == 0;
        }
        return false;//负数不可能是2的幂。
    }
}