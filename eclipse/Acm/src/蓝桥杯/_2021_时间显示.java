package 蓝桥杯;

import java.util.Scanner;

public class _2021_时间显示 {
	public static void main(String[] args) {
		
        Scanner scan = new Scanner(System.in);
        long t = scan.nextLong();
        t /= 1000;
        t %= 24 * 60 * 60;
        System.out.printf("%02d:",t / 3600);
        System.out.printf("%02d:", t%3600/60);
        System.out.printf("%02d\n", t%60);
        scan.close();
    }
}
