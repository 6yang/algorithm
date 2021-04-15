package nowcoder;


import java.util.ArrayList;
import java.util.List;

class Edge {
    int neighbor;
    int weight;

    Edge(int neighbor, int weight) {
        this.neighbor = neighbor;
        this.weight = weight;
    }
}

public class NC_99_TreeDiameter {
    private int diameter = 0;

    public int solve(int n, Interval[] Tree_edge, int[] Edge_value) {
        // write code here
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < Tree_edge.length; i++) {
            Interval interval = Tree_edge[i];
            int value = Edge_value[i];
            // 由于是无向图，所有每条边都是双向的
            graph[interval.start].add(new Edge(interval.end, value));
            graph[interval.end].add(new Edge(interval.start, value));
        }
        dfs(graph, 0, -1);
        return diameter;
    }


    private int dfs(List<Edge>[] graph, int node, int parent) {
        // 选出一个节点的第一深 和第二深
        int maxDepth = 0; //第一深
        int secondMaxDepth = 0;  //第二深
        for (Edge edge : graph[node]) {
            // 防止返回父节点
            if (edge.neighbor == parent) {
                continue;
            }
            int depth = edge.weight + dfs(graph, edge.neighbor, node);
            if (depth > maxDepth) {
                secondMaxDepth = maxDepth;
                maxDepth = depth;
            } else if (depth > secondMaxDepth) {
                secondMaxDepth = depth;
            }
        }
        diameter = Math.max(diameter, maxDepth + secondMaxDepth);
        return maxDepth;
    }
}
