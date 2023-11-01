package 蓝桥杯;

import java.util.Arrays;
import java.util.Scanner;

public class _2016_最大比例 {
	public static void main(String[] args) {
		//16 16*k  16*k*k 16*k*k*k
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[] a = new int[m];
		for(int i = 0;i < m;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for(int i = 0;i < m;i++) {
			
		}
		sc.close();
	}
	
	static int gcd(int a, int b) {
		return b == 0? a:gcd(b, a % b);
	}
	static int lcm(int a, int b) {
		return a * b/gcd(a, b);
	}
}
