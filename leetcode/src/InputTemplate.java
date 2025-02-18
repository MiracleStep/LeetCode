import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class InputTemplate {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter out = new PrintWriter(System.out);

    // StreamTokenizer
    private static int ini() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    private static double ind() throws IOException {
        st.nextToken();
        return st.nval;
    }

    private static String ins() throws IOException {
        st.nextToken();
        return st.sval;
    }

    public static void main(String[] args) throws IOException {
        // StreamTokenizer输入
        int n = ini();
        double m = ind();
        String s = ins();

        // BufferedReader输入
        String line1 = bin.readLine(); // 5
        int x = Integer.parseInt(line1);
        double y = Double.parseDouble(line1);

        // PrintWriter输出
        out.flush(); // 在控制台显示输出，不要忘记这句！
    }
}