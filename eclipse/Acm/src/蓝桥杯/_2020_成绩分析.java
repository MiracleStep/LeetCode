package 蓝桥杯;

import java.util.Scanner;

public class _2020_成绩分析 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0;i < n;i++) {
			int num = sc.nextInt();
			sum += num;
			max = Math.max(num, max);
			min = Math.min(min, num);
		}
		double av = (double)sum/n;
		System.out.println(max);
		System.out.println(min);
		System.out.printf("%.2f", av);
		sc.close();
	}
}
