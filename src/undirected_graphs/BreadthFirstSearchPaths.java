package undirected_graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearchPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BreadthFirstSearchPaths(Graph graph, int s) {
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        distTo = new int[graph.getV()];

        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        marked[s] = true;
        distTo[s] = 0;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    queue.offer(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }
}
