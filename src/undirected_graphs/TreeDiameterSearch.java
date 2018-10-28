package undirected_graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeDiameterSearch {
    private int source = 0;
    private int[] distTo;
    private int farthestVertex;

    public TreeDiameterSearch(Graph graph) {
        source = farthestVertex(graph, source);
        farthestVertex = farthestVertex(graph, source);
    }

    private int farthestVertex(Graph graph, int s) {
        boolean[] marked = new boolean[graph.getV()];
        distTo = new int[graph.getV()];

        int maxDist = 0;
        int farthest = s;

        Queue<Integer> queue = new ArrayDeque<>();
        marked[s] = true;
        distTo[s] = 0;

        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    queue.offer(w);
                    marked[w] = true;
                    distTo[w] = distTo[v] + 1;

                    if (distTo[w] > maxDist) {
                        maxDist = distTo[w];
                        farthest = w;
                    }
                }
            }
        }
        return farthest;
    }

    public int getDiameter() {
        return distTo[farthestVertex];
    }
}
