package b;

public class HeapItem {
    private int vertexID;
    private int weight;

    public HeapItem() {}

    public HeapItem(int vertexID, int weight) {
        this.vertexID = vertexID;
        this.weight = weight;
    }

    public int getVertexID() {
        return vertexID;
    }

    public void setVertexID(int vertexID) {
        this.vertexID = vertexID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
