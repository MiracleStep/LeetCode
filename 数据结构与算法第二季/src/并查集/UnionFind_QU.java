package 并查集;

public class UnionFind_QU extends UnionFind{
    public UnionFind_QU(int capacity){
        super(capacity);
    }

    /**
     * 通过parent链条不断向上找。
     * @param v
     * @return
     */
    @Override
    public int find(int v) {
        rangeCheck(v);
        while(v != parents[v]){
            v = parents[v];
        }
        return v;
    }

    /**
     * 将V1的根节点嫁接在V2的根节点上。
     * @param v1
     * @param v2
     */
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2) return;
        parents[p1] = p2;
    }
}
