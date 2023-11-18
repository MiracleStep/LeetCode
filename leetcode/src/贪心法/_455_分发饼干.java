package 贪心法;

import java.util.Arrays;

public class _455_分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while(child < g.length && cookie < s.length){
            if(s[cookie] >= g[child]){
                child++;
            }
            cookie++;
        }
        return child;
    }
}
