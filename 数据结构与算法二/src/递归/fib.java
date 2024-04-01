package 递归;

public class fib {
    public static void main(String[] args) {
//        System.out.println(fib(5));
        System.out.println(fib3(5));
    }

    private static int fib(int n){
        if(n == 0 || n == 1)return 1;
        int[] array = new int[n + 1];
        array[0] = array[1] = 1;
        return fib(n, array);
    }

    static int fib(int n, int[] array){
        if (array[n] == 0){
            array[n] = fib(n-1, array) + fib(n-2, array);
        }
        return array[n];
    }
    //1 1 2 3 5 8

    static int fib3(int n){
        if(n <= 2)return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n;i++){
            array[i % 2] = array[(i-1)%2] + array[(i-2)%2];
        }
        return array[n%2];
    }
}
