package 并查集;

public class Main {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind_QU_R(12);
        unionFind.union(0,1);
        unionFind.union(0,3);
        unionFind.union(0,4);
        unionFind.union(2,3);
        unionFind.union(2,5);

        unionFind.union(6,7);

        unionFind.union(8,10);
        unionFind.union(9,10);
        unionFind.union(9,11);

        unionFind.union(0, 11);

        System.out.println(unionFind.isSame(0, 5));
        System.out.println(unionFind.isSame(0, 11));
    }
}
