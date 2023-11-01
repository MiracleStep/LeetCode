package 字符串;

public class LCR_122_路径加密 {
    public String pathEncryption(String path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++){
            if(path.charAt(i) == '.'){
                sb.append(' ');
            } else{
                sb.append(path.charAt(i));
            }
        }
        return sb.toString();
    }
}
