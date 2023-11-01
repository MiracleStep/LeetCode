package 蓝桥杯;

import java.util.Scanner;

public class _2021_最少砝码2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum = 1, cur = 1;
		while(sum < n) {
			sum += Math.pow(3, cur);
			cur++;
		}
		System.out.println(cur);
		sc.close();
	}
}
