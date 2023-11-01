package 蓝桥杯;

import java.util.Scanner;

public class _2017_购物单 {
	//用excel做题
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			String str = sc.nextLine();
			String[] split = str.split(" ");
			if(split.length >= 2) {
				System.out.println(split[split.length-1]);
			}
			
		}
		
	}
}
