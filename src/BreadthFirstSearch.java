import java.util.*;
class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(WeightedGraph<T> graph) {
        super(graph);
    }

    public void bfs(Vertex<T> start) {
        validateVertex(start);

        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        for (Vertex<T> vertex : graph.adjacencyList.keySet()) {
            visited.put(vertex, false);
        }

        Queue<Vertex<T>> queue = new LinkedList<>();
        visited.put(start, true);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            List<Edge<T>> neighbors = graph.getNeighbors(currentVertex);
            for (Edge<T> edge : neighbors) {
                Vertex<T> neighbor = edge.getDestination();
                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    queue.offer(neighbor);
                }
            }
        }
    }

    private void validateVertex(Vertex<T> vertex) {
        if (!graph.adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is out of range");
        }
    }
}