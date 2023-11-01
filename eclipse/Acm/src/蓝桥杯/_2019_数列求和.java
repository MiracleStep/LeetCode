package 蓝桥杯;

import java.util.Scanner;

public class _2019_数列求和 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long a = 1, b = 1, c = 1;
		long y = 0;
		for(long i = 4; i <= 20190324;i++) {
			y = (a + b + c) % 10000;
			a = b;
			b = c;
			c = y;
		}
		System.out.println(y);
		scan.close();
	}
}
