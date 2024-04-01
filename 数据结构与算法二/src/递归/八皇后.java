package 递归;

public class 八皇后 {
    public static void main(String[] args) {
        new 八皇后().placeQueens(8);

    }

    boolean[] cols;
    boolean[] leftTop;
    boolean[] rightTop;
    int way;
    int n;

    void placeQueens(int n) {
        this.n = n;
        if (n < 1) return;
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        System.out.println(n + "皇后一共有" + way + "次方法。");
    }

    /**
     * 从第row行开始摆放皇后
     *
     * @param row
     */
    void place(int row) {
        if (row == n) {
            way++;
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                cols[col] = true;
                leftTop[row - col + cols.length - 1] = true;
                rightTop[row + col] = true;

                place(row + 1);

                cols[col] = false;
                leftTop[row - col + cols.length - 1] = false;
                rightTop[row + col] = false;
            }
        }
    }

    boolean isValid(int row, int col) {
        if (cols[col] || leftTop[row - col + cols.length - 1] || rightTop[row + col]) return false;
        return true;
    }
}
