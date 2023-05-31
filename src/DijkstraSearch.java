import java.util.*;

class DijkstraSearch<T> extends Search<T> {
    private Map<Vertex<T>, Integer> distances;
    private Map<Vertex<T>, Vertex<T>> parents;

    public DijkstraSearch(WeightedGraph<T> graph) {
        super(graph);
    }

    public void dijkstra(Vertex<T> start) {
        validateVertex(start);

        distances = new HashMap<>();
        parents = new HashMap<>();
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (Vertex<T> vertex : graph.adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
            parents.put(vertex, null);
        }

        distances.put(start, 0);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.poll();

            List<Edge<T>> neighbors = graph.getNeighbors(currentVertex);
            for (Edge<T> edge : neighbors) {
                Vertex<T> neighbor = edge.getDestination();
                int newDistance = distances.get(currentVertex) + edge.getWeight();

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    parents.put(neighbor, currentVertex);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public int getShortestDistance(Vertex<T> vertex) {
        validateVertex(vertex);
        return distances.get(vertex);
    }

    public List<Vertex<T>> getShortestPath(Vertex<T> vertex) {
        validateVertex(vertex);

        List<Vertex<T>> path = new LinkedList<>();
        Vertex<T> currentVertex = vertex;

        while (currentVertex != null) {
            path.add(0, currentVertex);
            currentVertex = parents.get(currentVertex);
        }

        return path;
    }

    private void validateVertex(Vertex<T> vertex) {
        if (!graph.adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is out of range");
        }
    }
}