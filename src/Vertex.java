import java.util.*;

class Vertex<T> {
    private T data;

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String toString() {
        return data.toString();
    }
}