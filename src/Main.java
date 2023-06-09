import java.util.*;
public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(); // Create a weighted graph
        // Create vertices
        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");
        Vertex<String> v5 = new Vertex<>("E");
        // Add vertices to the graph
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        // Add edges to the graph
        graph.addEdge(v1, v2, 2);
        graph.addEdge(v1, v3, 4);
        graph.addEdge(v2, v3, 1);
        graph.addEdge(v2, v4, 7);
        graph.addEdge(v3, v4, 3);
        graph.addEdge(v3, v5, 5);
        graph.addEdge(v4, v5, 2);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph); // Perform breadth-first search traversal
        System.out.print("BFS traversal: ");
        bfs.bfs(v1);
        System.out.println();

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph); // Perform Dijkstra's algorithm to find the shortest path
        dijkstra.dijkstra(v1);

        Vertex<String> destination = v5; // Find the shortest distance and path from v1 to v5
        int shortestDistance = dijkstra.getShortestDistance(destination);
        List<Vertex<String>> shortestPath = dijkstra.getShortestPath(destination);

        System.out.println("Shortest distance from " + v1 + " to " + destination + ": " + shortestDistance);
        System.out.println("Shortest path: " + shortestPath);
    }
}