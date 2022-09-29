package b;

public class QueueNode {
	private int vertexID;
	private int weight;
	
	public QueueNode() {}
	
	public QueueNode(int vertexID, int weight) {
		this.vertexID = vertexID;
		this.weight = weight;
	}
	
	public int getVertexID() {
        return vertexID;
    }

    public int getWeight() {
        return weight;
    }
}
