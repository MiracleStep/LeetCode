class Solution {
    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        StringBuilder sb = new StringBuilder();
        int left = alen - 1;
        int right = blen - 1;
        int sum = 0;
        while (left >= 0 && right >= 0) {
            sum += Integer.parseInt(String.valueOf(a.charAt(left)));
            sum += Integer.parseInt(String.valueOf(b.charAt(right)));
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
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }
}