import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
        for (Integer value : map.values()) {
            System.out.println(value);
        }
    }
}
