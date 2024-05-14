import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws ParseException {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(123);
        deque.offerLast(345);
        deque.offer(333);// == add() && addLast()
        deque.offerFirst(67); // push
        System.out.println(deque);//[67, 123, 345, 333]
        System.out.println(deque.pop());//67   还有 peekLast() peekFirst()等函数
        deque.push(33);
        System.out.println(deque);
        System.out.println(deque.peek());//67   还有 peekLast() peekFirst()等函数
        System.out.println(deque.poll());//67  == remove() && removeFirst() && pollFirst()
        //常用：offerLast offerFirst pollLast pollFirst peekLast peekFirst
    }
}
