import java.util.*;

class DijkstraSearch<T> extends Search<T> { // Class implementing Dijkstra's algorithm for finding the shortest path in a graph
    private Map<Vertex<T>, Integer> distances;
    private Map<Vertex<T>, Vertex<T>> parents;

    public DijkstraSearch(WeightedGraph<T> graph) {
        super(graph);
    }

    public void dijkstra(Vertex<T> start) {// Perform Dijkstra's algorithm on the graph starting from the specified vertex
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

    public int getShortestDistance(Vertex<T> vertex) { // Get the shortest distance to the specified vertex from the start vertex
        validateVertex(vertex);
        return distances.get(vertex);
    }

    public List<Vertex<T>> getShortestPath(Vertex<T> vertex) { // Get the shortest path to the specified vertex from the start vertex
        validateVertex(vertex);

        List<Vertex<T>> path = new LinkedList<>();
        Vertex<T> currentVertex = vertex;

        while (currentVertex != null) {
            path.add(0, currentVertex);
            currentVertex = parents.get(currentVertex);
        }

        return path;
    }

    private void validateVertex(Vertex<T> vertex) { // Validate if a vertex is present in the graph
        if (!graph.adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is out of range");
        }
    }
}