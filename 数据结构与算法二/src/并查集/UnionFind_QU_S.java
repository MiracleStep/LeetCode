package 并查集;

public class UnionFind_QU_S extends UnionFind{
    //基于Quick Union基于size的优化
    private int[] sizes;
    public UnionFind_QU_S(int capacity){
        super(capacity);

        sizes = new int[capacity];
        for (int i = 0;i < sizes.length;i++){
            sizes[i] = 1;
        }
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
        if(sizes[p1] < sizes[p2]){
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
        }else {
            parents[p2] = p1;
            sizes[p1] += sizes[p2];
        }
    }
}
