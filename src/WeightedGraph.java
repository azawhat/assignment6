import java.util.*;
class WeightedGraph<T> { // Class representing a weighted graph
    public Map<Vertex<T>, List<Edge<T>>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<T> vertex) { // Add a vertex to the graph
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, int weight) {     // Add an edge between two vertices with a weight

        validateVertex(source);
        validateVertex(destination);
        adjacencyList.get(source).add(new Edge<>(source, destination, weight));
        adjacencyList.get(destination).add(new Edge<>(destination, source, weight));
    }

    private void validateVertex(Vertex<T> vertex) {     // Validate if a vertex is present in the graph

        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is out of range");
        }
    }

    public List<Edge<T>> getNeighbors(Vertex<T> vertex) {     // Get the list of edges connected to a vertex

        validateVertex(vertex);
        return adjacencyList.getOrDefault(vertex, new LinkedList<>());
    }
}
