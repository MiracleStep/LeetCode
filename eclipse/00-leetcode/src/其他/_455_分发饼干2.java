package 其他;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _455_分发饼干2 {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
        int numOfchidren = g.length,numOfcookie = s.length;
        int count = 0;
        for(int i=0,j=0;i<numOfchidren && j<numOfcookie;i++,j++) {
        	while(j<numOfcookie&&g[i]>s[i]) {
        		j++;
        	}
        	if(j< numOfchidren) {
        		count++;
        	}
        }
        return count;
    }
}
