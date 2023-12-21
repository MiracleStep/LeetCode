import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        HashMap<Integer, Integer> areasMap = new HashMap();
        areasMap.put(123, 435);
        areasMap.put(323, 445);


        areasMap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
