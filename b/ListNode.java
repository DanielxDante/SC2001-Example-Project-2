package b;

public class ListNode {
	private int vertexID;
	private int weight;
	private ListNode next;
	
	public ListNode() {}
	
	public ListNode(int vertexID, int weight) {
		// initialise each weighted edge node
		this.vertexID = vertexID;
		this.weight = weight;
		this.next = null;
	}
	
	public int getVertexID() {
		return this.vertexID;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setNext(ListNode nextNode) {
		this.next = nextNode;
	}
	
	public ListNode getNext() {
		return this.next;
	}
	
}
