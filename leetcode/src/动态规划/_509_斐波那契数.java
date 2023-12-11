package 动态规划;

public class _509_斐波那契数 {
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int a =0,b=1,c=0;
        for(int i =1;i<n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
