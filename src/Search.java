class Search<T> { // Base class for graph searches

    protected WeightedGraph<T> graph;

    public Search(WeightedGraph<T> graph) {
        this.graph = graph;
    }
}