package 蓝桥杯;

import java.util.Scanner;

public class 回文判定 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
        	if(str.charAt(i) != str.charAt(j))break;
        	i++;
        	j--;
        }
        if(i >= j) {
        	System.out.println("Y");
        }else {
        	System.out.println("N");
        }
        scan.close();
    }
}
