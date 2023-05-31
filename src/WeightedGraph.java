import java.util.*;
class WeightedGraph<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<T> vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, int weight) {
        validateVertex(source);
        validateVertex(destination);
        adjacencyList.get(source).add(new Edge<>(source, destination, weight));
        adjacencyList.get(destination).add(new Edge<>(destination, source, weight));
    }

    private void validateVertex(Vertex<T> vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is out of range");
        }
    }

    public List<Edge<T>> getNeighbors(Vertex<T> vertex) {
        validateVertex(vertex);
        return adjacencyList.getOrDefault(vertex, new LinkedList<>());
    }
}
