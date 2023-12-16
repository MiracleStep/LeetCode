import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(123);
        deque.add(234);
        deque.add(1255);
        System.out.println(deque.poll());
    }
}
