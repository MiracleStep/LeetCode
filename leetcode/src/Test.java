import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Integer a = 12;
        Integer b = 32;
        double c = ((double)a - b) / b * 100;
        Integer f = (int) c;
        System.out.println(f);
    }
}
