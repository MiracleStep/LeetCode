package 数组;

public class _12_整数转罗马数字 {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            int val = values[i];
            String sym = symbols[i];
            while (num >= val) {
                num -= val;
                sb.append(sym);
            }
        }
        return sb.toString();
    }}
