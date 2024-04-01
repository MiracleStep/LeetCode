import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {
    public static void main(String[] args) {
        Integer[] faces = {25, 5, 10, 1};
        //降序
        Arrays.sort(faces, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });

        int money = 41, coins = 0;
        for (int i = 0;i < faces.length;i++){
            while (money >= faces[i]){
                money -= faces[i];
                coins++;
                System.out.println(faces[i]);
            }
        }
    }
}
