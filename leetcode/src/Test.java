import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(123);
        deque.addLast(345);
        deque.offer(333);// == add() 函数
        deque.addFirst(67);
        System.out.println(deque);//[67, 123, 345, 333]
        System.out.println(deque.peek());//67
        System.out.println(deque.remove());//67
        ArrayList<Integer> arrayList;
        arrayList = new ArrayList<>();
    }
}
