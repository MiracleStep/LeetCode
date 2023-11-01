package 蓝桥杯;

import java.util.Arrays;

public class 埃式筛 {
	public static void main(String[] args) {
		int n = 10;
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for(int i = 2;i <= Math.sqrt(n);i++) {
			if(isPrime[i]) {
				for(int j = i*i;j <= n;j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		for(int i = 2;i <= n;i++) {
			if(isPrime[i]) {
				System.out.print(i+" ");
			}
		}
	}
}
