package 位运算;

public class LCR_002_二进制求和 {
    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        StringBuilder sb = new StringBuilder();
        int left = alen - 1;
        int right = blen - 1;
        int sum = 0;
        while (left >= 0 && right >= 0) {
            sum += a.charAt(left) - '0';
            sum += b.charAt(right) - '0';
            if (sum == 2) {
                sum = 1;
                sb.insert(0, "0");
            } else if (sum == 1) {
                sum = 0;
                sb.insert(0, "1");
            } else if (sum == 3) {
                sum = 1;
                sb.insert(0, "1");
            } else {
                sum = 0;
                sb.insert(0, "0");
            }
            left--;
            right--;
        }
        while (left >= 0) {
            sum += a.charAt(left) - '0';

            if (sum == 2) {
                sum = 1;
                sb.insert(0, "0");
            } else if (sum == 1) {
                sum = 0;
                sb.insert(0, "1");
            } else {
                sum = 0;
                sb.insert(0, "0");
            }
            left--;
        }
        while (right >= 0) {
            sum += b.charAt(right) - '0';
            if (sum == 2) {
                sum = 1;
                sb.insert(0, "0");
            } else if (sum == 1) {
                sum = 0;
                sb.insert(0, "1");
            } else {
                sum = 0;
                sb.insert(0, "0");
            }
            right--;
        }
        if (sum == 1) {
            sb.insert(0, "1");
        }
        return sb.toString();
    }
}
