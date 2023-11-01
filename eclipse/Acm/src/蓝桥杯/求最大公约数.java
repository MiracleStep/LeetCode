package 蓝桥杯;

import java.util.Scanner;

public class 求最大公约数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0;i < n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(gcd(a, b));
		}
		
		sc.close();
	}
	
	static int gcd(int a, int b) {
		return b == 0?a:gcd(b, a % b);
	}
}
