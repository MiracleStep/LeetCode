import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        System.out.println(computeLevenshteinDistance("携程", "同程"));
    }
    private static int computeLevenshteinDistance(String descHotel, String poiHotel) {
        int[][] distance = new int[descHotel.length() + 1][poiHotel.length() + 1];

        for (int i = 0; i <= descHotel.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= poiHotel.length(); j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= descHotel.length(); i++) {
            for (int j = 1; j <= poiHotel.length(); j++) {
                if (descHotel.charAt(i - 1) == poiHotel.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    int insert = distance[i][j - 1] + 1;
                    int delete = distance[i - 1][j] + 1;
                    int replace = distance[i - 1][j - 1] + 1;
                    distance[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }
        return distance[descHotel.length()][poiHotel.length()] * 100 / descHotel.length();
    }

}



