from random import randint

def main():
    vertices = 1000
    genCompleteGraph(vertices) # call to generate the complete graph for a given no. of vertices

    for i in range(1, vertices-1, 200):
        genPartialGraph(vertices, i)


def genCompleteGraph(vertices): 
    filename = 'completeGraphSize' + str(vertices) + '.txt'
    f = open(filename, 'w')
    f.write(str(vertices) + '\n')
    max_edges = calMaxEdges(vertices)
    f.write(str(max_edges) + '\n')
    for v in range(1, vertices+1):
        for a in range(1, vertices+1):
            if a != v:
                weight = randint(1, 50)
                f.write(str(v) + '\n')
                f.write(str(a) + '\n')
                f.write(str(weight) + '\n')
    f.close()

def genPartialGraph(vertices, edges_per_vertex):
    filename = 'partialGraphSize' + str(vertices) + str(edges_per_vertex) + 'EdgesPerVextex.txt'
    f = open(filename, 'w')
    f.write(str(vertices) + '\n')
    max_edges = vertices * edges_per_vertex
    f.write(str(max_edges) + '\n')
    a = 1
    edge_count = 0
    for v in range(1, vertices+1):
        while(edge_count != edges_per_vertex):
            if a != v:
                weight = randint(1, 50)
                f.write(str(v) + '\n')
                f.write(str(a) + '\n')
                f.write(str(weight) + '\n')
                edge_count += 1 # increment edge_count only if an edge has been added
            a += 1
    f.close()


def calMaxEdges(vertices):
    max_edges = vertices * (vertices - 1) # N(N-1) * probability
    return max_edges


if __name__ == '__main__':
    main()
