package 蓝桥杯;

import java.util.Scanner;

public class _2021_门牌制作 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong();
		l /= 1000;
		int s = (int)l%60;
		l /= 60;
		int m = (int)l%60;
		l /= 60;
		int h = (int)l % 24;
		System.out.printf("%02d:%02d:%02d",h,m,s);
		sc.close();
	}
}
