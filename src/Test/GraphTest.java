
package Test;

import Model.Graph.Dijkstra;
import Model.Graph.DirectedEdge;
import Model.Graph.DirectedGraph;

public class GraphTest {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(7);
        graph.addEdge(new DirectedEdge(0, 1, 4));
        graph.addEdge(new DirectedEdge(0, 2, 3));
        graph.addEdge(new DirectedEdge(0, 3, 7));

        graph.addEdge(new DirectedEdge(1, 3, 1));
        graph.addEdge(new DirectedEdge(1, 5, 4));

        graph.addEdge(new DirectedEdge(2, 3, 3));
        graph.addEdge(new DirectedEdge(2, 4, 5));

        graph.addEdge(new DirectedEdge(3, 4, 2));
        graph.addEdge(new DirectedEdge(3, 5, 2));
        graph.addEdge(new DirectedEdge(3, 6, 7));

        graph.addEdge(new DirectedEdge(4, 6, 2));

        graph.addEdge(new DirectedEdge(5, 6, 4));

        int source = 0;
        Dijkstra shortestPath = new Dijkstra(graph, source);

        for (int target = 0; target < graph.getNumberOfVertices(); target++) {
            if (shortestPath.hasPathTo(target)) {
                System.out.printf("%d do %d (%d)  ", source, target,
                        shortestPath.getDistanceTo(target));
                if (shortestPath.hasPathTo(target)) {
                    for (DirectedEdge edge : shortestPath.getPathTo(target)) {
                        System.out.print(edge);
                    }
                }
            } else {
                System.out.printf("%d do %d - brak sciezki  ", source, target);
            }
            System.out.println();
        }

    }
}
