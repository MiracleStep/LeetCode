package 数组;

import java.util.Arrays;

public class _274_H指数 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = citations.length - 1, h = 0;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
