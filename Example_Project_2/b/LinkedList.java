package b;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public ListNode getHead() {
        return head;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public void addNode(int vertexID, int weight) {
        ListNode newNode = new ListNode(vertexID, weight);
        if (isEmpty() == true)// empty linked list
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public void printLinkedList() {
        ListNode currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print("(" + currentNode.getVertexID() + ", " + currentNode.getWeight() + ")");
            if (i + 1 != size)
                System.out.print(" -> ");
            currentNode = currentNode.getNext();
        }
    }
}
