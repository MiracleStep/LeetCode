package 蓝桥杯;

import java.util.Scanner;

public class _2017_k倍区间 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] sum = new int[n+1];
		sum[0] = 0;
		for(int i = 1;i <= n;i++) {
			sum[i] = sum[i-1] + sc.nextInt();
		}
		
		int ans = 0;
		for(int i = 1;i <= n;i++) {
			for(int j = i;j <= n;j++) {
				if((sum[j] - sum[i-1])%k == 0) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
