package 并查集;

public class UnionFind_QF模板 {
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
        return parent[v];
    }

    public void union(int v1, int v2){
        int p1 = parent[v1];
        int p2 = parent[v2];
        if(p1 == p2) return;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == p1){
                parent[i] = p2;
            }
        }
    }

    public boolean isSame(int v1, int v2){
        return find(v1) == find(v2);
    }
}
