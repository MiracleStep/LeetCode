package 位运算;

public class LCR_003_比特位计数 {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        // 0  01 10 11 100 101 110 111 1000 1001 1010 1011 1100
        // 0  1  1  2  1   2   2   3   1
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                counts[i] = counts[i >> 1];
            } else {
                counts[i] = counts[i - 1] + 1;
            }
        }
        return counts;
    }
}
