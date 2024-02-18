package 图论;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207_课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表，记录每个节点的入度数
        int[] inDegrees = new int[numCourses];
        // 邻接表  
        List<List<Integer>> adjacency = new ArrayList<>();

        // 初始化邻接表，方便后面直接在对应位置赋值
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            // 统计每个节点的入度
            inDegrees[pre[0]]++;
            // 邻接表赋值，保存一个节点的所有入度相关节点；pre[1] -> pre[0]
            adjacency.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 将所有入度为0的节点存入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        // 出队，BFS 拓扑排序
        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            numCourses--;
            for (Integer cur : adjacency.get(pre)) {   //获取pre的所有出度对应的节点
                inDegrees[cur]--;  // 把这个元素相关的入度的数量减少
                if (inDegrees[cur] == 0) {  // 若入度为0，该cur完成了所有前置课程，放入队列
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>(); //邻接矩阵
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>()); //邻接矩阵初始化
        int[] flags = new int[numCourses]; // 1表示当前递归已经访问过了，-1表示之前递归访问过了，0表示未访问过。
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]); //建立邻接矩阵
        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, flags, i)) return false; //依次对每个节点进行深度优先遍历直到DFS遇到自己已经DFS过的节点
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false; // 当前递归已经访问过了，出现环。
        if (flags[i] == -1) return true; //之前递归已经访问过了，无需访问。
        flags[i] = 1;
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j)) return false;//DFS i的每一个出度节点。
        flags[i] = -1; //回溯，当前设置节点被其他节点遍历过了。
        return true;
    }
}
