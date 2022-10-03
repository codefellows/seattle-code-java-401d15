package datastructures.graph;

public class Edge<T extends Comparable<? super T>> implements Comparable<Vertex<T>>{

    public Vertex<T> destination;
    public int weight;

    public Edge(Vertex<T> destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Vertex<T> o) {
        throw new UnsupportedOperationException("Edge does not implement compareTo()");
    }
}
