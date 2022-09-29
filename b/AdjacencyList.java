package b;

public class AdjacencyList {
	private ListNode head;
	private int size;
	
	public AdjacencyList() {
		this.head = null;
		this.size = 0;
	}
	
	public void addEdge(int vertexID, int weight) { // add a new weighted edge to the list
		ListNode curNode;
		ListNode newNode = new ListNode(vertexID, weight);
		// check if the head list node is assigned or not
		if(this.head == null) {
			// add the new list node to the head of the linked list
			this.head = newNode;
		}
		else {
			// add the new list node to the end of the linked list
			curNode = this.head;
			while(curNode.getNext() != null) {
				curNode = curNode.getNext();
			}
			curNode.setNext(newNode);
		}
		this.size++;
	}
	
	public void removeEdge(int vertexID) {
		ListNode curNode, preNode, nextNode;
		// check if head of list is assigned
		if(this.head == null) {
			// nothing to remove, return
			return;
		}
		else if(this.head.getVertexID() == vertexID) {
			this.head = null;
			this.size--;
		}
		else {
			curNode = this.head.getNext();
			preNode = this.head;
			// loop until reach the node to be deleted
			while(curNode.getVertexID() != vertexID) {
				preNode = curNode;
				curNode = curNode.getNext();
			}
			// make the previous node point to the node after the node to be deleted
			nextNode = curNode.getNext();
			preNode.setNext(nextNode);
			curNode = null;
		}
	}
	
	public ListNode find(int vertexID) { // find if a given vertex is adjacent to current vertex and return its ListNode object
		ListNode curNode = this.head;
		while(curNode != null) {
			if(curNode.getVertexID() == vertexID) {
				return curNode;
			}
			curNode = curNode.getNext();
		}
		return null;
	}
	
	public ListNode getHead() {
		return this.head;
	}
	
	public boolean isEmpty() { // check if list is empty
		if(this.size == 0) {
			return true;
		}
		return false;
	}
}
