package 字符串;

public class LCR_182_动态口令 {
    public String dynamicPassword(String password, int target) {
        StringBuilder sb = new StringBuilder();
        for (int i = target; i < password.length(); i++){
            sb.append(password.charAt(i));
        }
        for (int i = 0; i < target; i++){
            sb.append(password.charAt(i));
        }
        return sb.toString();
    }
}
