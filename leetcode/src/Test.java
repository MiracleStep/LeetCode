public class Test {
    private int[] parent;
    private int[] sizes;
    public Test(int capacity) {
        parent = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            parent[i] = i;
        }
        sizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            sizes[i] = 1;
        }
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty) return;
        if (sizes[rootx] < sizes[rooty]) {
            parent[rootx] = rooty;
            sizes[rooty] += sizes[rootx];
        } else {
            parent[rooty] = rootx;
            sizes[rootx] += sizes[rooty];
        }
    }

    private boolean isSame(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        Test test = new Test(12);
        test.find(7);
        test.union(4, 5);
        test.union(3, 4);
        boolean same = test.isSame(3, 5);
        System.out.println(same);
    }
}



