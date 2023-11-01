package 蓝桥杯;

import java.util.Scanner;

public class _2019_特别数的和 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		
		for(int i = 0;i <= n;i++) {
			if(check(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
		sc.close();
	}
	
	public static boolean check(int x) {
		while(x != 0) {
			int y = x % 10;
			if(y == 2||y == 1||y == 9||y  == 0) {
				return true;
			}
			x /= 10;
		}
		return false;
	}
}
