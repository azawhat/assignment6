# Assignment 5
This is the 5th assignment of the Algorithms and Data Structure course

## Weighted Graph Algorithms

This repository contains Java implementations of two common algorithms applied to a weighted graph: breadth-first search (BFS) and Dijkstra's algorithm. The code demonstrates how to represent a weighted graph using objects and how to perform graph searches.

## Classes

The code is organized into several classes:

- `Vertex<T>`: Represents a vertex in the graph. It has a generic type `T` to store the data associated with the vertex.

- `Edge<T>`: Represents an edge between two vertices with a weight. It contains references to the source and destination vertices and the weight of the edge.

- `WeightedGraph<T>`: Represents a weighted graph. It maintains an adjacency list to store the vertices and their connected edges.

- `Search<T>`: Base class for graph searches. It provides a reference to the graph and common validation methods.

- `BreadthFirstSearch<T>`: Implements breadth-first search (BFS) on a graph. It performs a BFS traversal starting from a specified vertex.

- `DijkstraSearch<T>`: Implements Dijkstra's algorithm on a graph. It finds the shortest path from a specified start vertex to other vertices.

- `Main`: The main class that demonstrates the usage of the implemented classes. It creates a weighted graph, adds vertices and edges, performs a breadth-first search traversal, and finds the shortest path using Dijkstra's algorithm.

## Methods

The following are the main methods available in the classes:

- `Vertex<T>`:
  - `Vertex(T data)`: Constructor to create a vertex with the specified data.
  - `T getData()`: Returns the data associated with the vertex.
  - `toString()`: Returns a string representation of the vertex.

- `Edge<T>`:
  - `Edge(Vertex<T> source, Vertex<T> destination, int weight)`: Constructor to create an edge between two vertices with the specified weight.
  - `getSource()`: Returns the source vertex of the edge.
  - `getDestination()`: Returns the destination vertex of the edge.
  - `getWeight()`: Returns the weight of the edge.

- `WeightedGraph<T>`:
  - `addVertex(Vertex<T> vertex)`: Adds a vertex to the graph.
  - `addEdge(Vertex<T> source, Vertex<T> destination, int weight)`: Adds an edge between two vertices with the specified weight.
  - `getNeighbors(Vertex<T> vertex)`: Returns a list of edges connected to the specified vertex.

- `Search<T>`:
  - `Search(WeightedGraph<T> graph)`: Constructor to initialize the search with the specified graph.

- `BreadthFirstSearch<T>`:
  - `bfs(Vertex<T> start)`: Performs a breadth-first search traversal on the graph starting from the specified vertex.

- `DijkstraSearch<T>`:
  - `dijkstra(Vertex<T> start)`: Performs Dijkstra's algorithm on the graph starting from the specified vertex.
  - `getShortestDistance(Vertex<T> vertex)`: Returns the shortest distance to the specified vertex from the start vertex.
  - `getShortestPath(Vertex<T> vertex)`: Returns the shortest path to the specified vertex from the start vertex.

- `Main`:
  - `main(String[] args)`: The entry point of the program. It demonstrates the usage of the implemented classes.


