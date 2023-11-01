package 蓝桥杯;

import java.util.Scanner;

public class 分治法求x的n次幂 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(solve(x, n));
		sc.close();
	}

	private static int solve(int x, int n) {
		if(n == 1)return x;
		if(n % 2 == 0) {
			return solve(x, n/2)*solve(x, n/2);
		}else {
			return solve(x, n/2)*solve(x, n/2) * x;
		}
	}
	
}
