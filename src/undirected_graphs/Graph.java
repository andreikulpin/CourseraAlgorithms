package undirected_graphs;

import java.util.LinkedList;

public class Graph {
    private final int v;
    private LinkedList<Integer>[] adj; // adjacency lists

    public Graph(int v) {
        this.v = v;
        adj = (LinkedList<Integer>[]) new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        if (v != w) {
            adj[w].add(v);
        }
    }

    /* Return the number of vertices
    * */
    public int getV() {
        return v;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < v; i++) {
            builder.append(i).append(" -> ");
            for (int j = 0; j < adj[i].size(); j++) {
                builder.append(adj[i].get(j)).append(", ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
