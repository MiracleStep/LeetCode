package 递归;

public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbstairs2(3));
    }
    static int climbstairs(int n){
        if(n <= 2) return n;
        return climbstairs(n-1) + climbstairs(n - 2);
    }

    static int climbstairs2(int n){
        if(n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n;i++){
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
