package b;

public class GraphList {
    private LinkedList adjList[];
    private int numVertices;

    public GraphList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        adjList[v1 - 1].addNode(v2, weight);
    }

    public void printList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print((i + 1) + ": ");
            adjList[i].printLinkedList();
            System.out.println();
        }
    }

    public LinkedList[] getList() {
        return adjList;
    }
}
