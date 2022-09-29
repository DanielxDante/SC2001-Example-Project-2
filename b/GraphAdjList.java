package b;

class GraphAdjList { // directed adjacency list to store graph
    private AdjacencyList adjList[];
    private int numVertices;
    private int numEdges;

    public GraphAdjList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new AdjacencyList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new AdjacencyList(); // each index in the adjList array holds an empty linked list
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        adjList[v1].addEdge(v2, weight);
        this.numEdges++;
    }

    public void removeEdge(int v1, int v2) {
        adjList[v1].removeEdge(v2);
        this.numEdges--;
    }

    public void printAdjList() {
        int i;
        ListNode curNode;
        for (i = 0; i < numVertices; i++) {
            System.out.print((i+1) + ": ");
            if(!adjList[i].isEmpty()) {
            	curNode = adjList[i].getHead();
            	System.out.print("(" + curNode.getVertexID() + ", " + curNode.getWeight() + ")");
            	while(curNode.getNext() != null) {
            		curNode = curNode.getNext();
            		System.out.print(" -> " + "(" + curNode.getVertexID() + ", " + curNode.getWeight() + ")");
            	}
            }
            System.out.println();
        }
        System.out.println();
    }

    public AdjacencyList[] getAdjList() {
        return adjList;
    }
}