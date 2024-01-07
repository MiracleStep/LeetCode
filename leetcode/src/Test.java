import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(123);
        deque.addLast(345);
        deque.offer(333);
        System.out.println(deque);
    }
}
