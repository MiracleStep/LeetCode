package 图论;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _797_所有可能的路径 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        Deque<Integer> path = new LinkedList<>();
        path.offer(0);
        //这里的graph相当于邻接表，而不是邻接矩阵
        dfs(graph, path, n - 1, 0);
        return res;
    }

    private void dfs(int[][] graph, Deque<Integer> path, int n, int x) {
        if (x == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i : graph[x]) {
            path.offer(i);
            dfs(graph, path, n, i);
            path.pollLast();
        }
    }
}
