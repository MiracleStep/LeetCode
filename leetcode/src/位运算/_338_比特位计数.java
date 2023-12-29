package 位运算;

public class _338_比特位计数 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        /*
        000000
        000001
        000010
        000011
        000100
        000101
        000110
        000111
        001000
        */
        res[0] = 0;
        for(int i = 0; i <= n; i++){
            if(i % 2 == 1){
                //奇数
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i / 2];
            }
        }
        return res;
    }
}
