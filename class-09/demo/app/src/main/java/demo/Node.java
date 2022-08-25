package demo;

public class Node<T> {
    T value;
    Node<T> next = null;

    public Node(T value) {
        this.value = value;
    }

}

