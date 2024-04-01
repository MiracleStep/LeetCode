package 并查集;

import java.util.Arrays;

public class UnionFind_QU_R extends UnionFind{
    //Quick Union基于rank的优化。
    private int[] ranks;
    public UnionFind_QU_R(int capacity){
        super(capacity);
        ranks = new int[capacity];
        Arrays.fill(ranks, 1);
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
        if(ranks[p1] < ranks[p2]){
            parents[p1] = p2;
        }else if(ranks[p1] > ranks[p2]){
            parents[p2] = p1;
        }else {
            parents[p1] = p2;
            ranks[p2] += 1;
        }
    }
}
