package datastructures.graph;

import java.net.CookieManager;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>> {

    public HashMap<Vertex<T>, LinkedList<Edge<T>>> adjacencyLists;
    private int numberOfVertices = 0;

    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    public Vertex<T> addVertex(T value)  // addNode()
    {
        // TODO: implement me
        return null;
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination)
    {
        addEdge(start, destination, 0);
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination, int weight)
    {
        // TODO: implement me
    }

    public LinkedList<Vertex<T>> getVertices()  // getNodes()
    {
        // TODO: implement me
        return null;
    }

    public LinkedList<Edge<T>> getNeighbors(Vertex<T> vertex)
    {
        // TODO: implement me
        return null;
    }

    public int size()
    {
        return numberOfVertices;  // TODO: make sure this gets updated at the right times
    }

    @Override
    public int compareTo(Graph<T> o)
    {
        throw new UnsupportedOperationException("Graph does not implement compareTo()");
    }

    @Override
    public String toString()
    {
        // Good for testing
        // WARNING: Your HashMap does not guarantee ordering!
        // But you can basically rely on it if you add nodes to your graphs in a consistent way

        return "";
    }
}
