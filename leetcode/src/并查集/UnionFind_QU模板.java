package 并查集;

public class UnionFind_QU模板 {
    int[] parent;
    public void init(int n){
        if(n >= 0){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
    }

    public int find(int v){
        while(v != parent[v]){
            v = parent[v];
        }
        return v;
    }

    public void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2) return;
        parent[p1] = p2;
    }

    public boolean isSame(int v1, int v2){
        return find(v1) == find(v2);
    }
}
