package 二分查找;

public class _69_x的平方根 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if((long)(mid * mid) > x){
                right = mid - 1;
            } else if((long)(mid * mid) < x){
                left = mid + 1;
            } else if((long)(mid * mid) == x){
                return (int)mid;
            }
        }
        //while时没有retrun结束则按照 <= x最大的值返回。
        //结合题目来看right肯定是符合题目要求的，不需要判断直接返回
        return (int)right;
    }

    //非常简单但不是最优的解法。
    public int mySqrt2(int x) {
        long i = 1;
        while (i * i <= x) {
            i += 1;
        }
        return (int)(i - 1);
    }
}
