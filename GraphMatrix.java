package a;

class GraphMatrix { // directed adjacency matrix to store graph
    private int adjMatrix[][];
    private int numVertices;

    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = -1; // we take -1 to be infinity
            }
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        adjMatrix[v1][v2] = weight;
    }

    public void removeEdge(int v1, int v2) {
        adjMatrix[v1][v2] = -1;
    }

    public void printMatrix() {
        int i, j;
        for (i = 0; i < numVertices; i++) {
            System.out.print("\t" + (i + 1));
        }
        System.out.println();
        for (i = 0; i < numVertices; i++) {
            System.out.print((i + 1) + "\t");
            for (j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] getMatrix() {
        return adjMatrix;
    }
}