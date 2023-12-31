package 并查集;

public abstract class UnionFind_QF extends UnionFind{
    private int[] parents;

    public UnionFind_QF(int capacity){
        super(capacity);
    }

    public int find(int v){
        rangeCheck(v);
        return parents[v];
    }

    /**
     * 合并v1和v2所在的集合
     * @param v1
     * @param v2
     */
    public void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        for(int i = 0;i < parents.length; i++){
            if (parents[i] == p1){
                parents[i] = p2;
            }
        }
    }

    public boolean isSame(int v1, int v2){
        return find(v1) == find(v2);
    }

}
