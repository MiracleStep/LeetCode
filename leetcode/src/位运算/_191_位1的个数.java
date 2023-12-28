package 位运算;

public class _191_位1的个数 {
    //优化代码
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res++;
            n &= n - 1;
        }
        return res;
    }
    public int hammingWeight2(int n) {
        int res = 0;
        while(n != 0){
            res += n&1;
            n >>>=1;//无符号右移，>>是有符号右移。
        }
        return res;
    }
}
