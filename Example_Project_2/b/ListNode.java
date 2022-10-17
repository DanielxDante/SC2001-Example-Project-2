package b;

public class ListNode {
    private int vertexID;
    private int weight;
    private ListNode next;

    public ListNode(int vertexID, int weight) {
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

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    
}
