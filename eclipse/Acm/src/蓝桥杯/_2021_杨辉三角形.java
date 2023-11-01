package 蓝桥杯;

import java.util.Scanner;

public class _2021_杨辉三角形 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long num = scan.nextLong();
        int[] list = {1,1,1,1,2,1,1,3,3,1,1,4,6,4,1,1,5,10,10,5,1,1,6,15,20,15,6,1,1,7,21,35,35,21,7,1};
        for(int i = 0;i < list.length;i++) {
        	if(list[i] == num) {
        		System.out.println(i+1);
        		break;
        	}
        }
        
        scan.close();
    }
}
