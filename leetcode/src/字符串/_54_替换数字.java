package 字符串;

import java.util.Scanner;

public class _54_替换数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < 58 && ch >= 48) {
                sb.append("number");
            } else {
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}