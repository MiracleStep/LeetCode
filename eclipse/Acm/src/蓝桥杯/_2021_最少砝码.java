package 蓝桥杯;

import java.util.Scanner;

public class _2021_最少砝码 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long num = scan.nextLong();
        int sum = 0, cur = 0;
        while(sum < num) {
        	sum += Math.pow(3, cur);
        	cur++;
        }
        System.out.println(cur);
        scan.close();
    }
}
