package undirected_graphs;

public class Sample {
    public static void main(String[] args) {
        Graph graph = createMockGraph(7);

        System.out.println(graph);

        printPaths(graph);

        int diameter = new TreeDiameterSearch(graph).getDiameter();
        System.out.println("\nDiameter = " + diameter);
    }

    private static Graph createMockGraph(int vertexCount) {
        Graph graph = new Graph(vertexCount);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(6, 1);
        return graph;
    }

    private static void printPaths(Graph graph) {
        final int rootVertex = 0;
        DepthFirstSearchPaths depthFirstSearchPaths = new DepthFirstSearchPaths(graph, rootVertex);
        for (int v = 0; v < graph.getV(); v++) {
            if (depthFirstSearchPaths.hasPathTo(v)) {
                Iterable<Integer> path = depthFirstSearchPaths.pathTo(v);
                System.out.print("Path to " + v + ": ");
                for (int i : path) {
                    System.out.print(i + " ");
                }
                System.out.println();
            } else {
                System.out.println("Vertex " + v + " is not connected to " + rootVertex);
            }
        }
    }
}
