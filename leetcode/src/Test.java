import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(len - k, len));
        sb.append(s.substring(0, len - k));
        System.out.println(sb.toString());
    }
}
