package undirected_graphs;

import java.util.Stack;

public class DepthFirstSearchPaths {
    private boolean[] marked; // marked[v] is true if v is connected to s
    private int[] edgeTo; // edgeTo[v] is previous vertex on path from s to v
    private int s;

    public DepthFirstSearchPaths(Graph graph, int s) {
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];

        dfs(graph, s);
        // nonrecursiveDfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
                edgeTo[w] = v;
            }
        }
    }

    private void nonrecursiveDfs(Graph graph, final int initialVertex) {
        int v = initialVertex;
        marked[v] = true;
        while (true) {
            boolean allMarked = true;
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    allMarked = false;
                    edgeTo[w] = v;
                    marked[w] = true;
                    v = w;
                    break;
                }
            }

            if (allMarked) {
                if (v == initialVertex) break;
                v = edgeTo[v];
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(s);
        return path;
    }
}
