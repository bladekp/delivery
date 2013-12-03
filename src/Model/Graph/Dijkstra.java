
package Model.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

    private DirectedEdge[] edgeTo;
    private Long[] distanceTo;
    private Queue<DistanceToEdge> priorityQueue;

    public Dijkstra(DirectedGraph graph, int source) {
        edgeTo = new DirectedEdge[graph.getNumberOfVertices()];
        distanceTo = new Long[graph.getNumberOfVertices()];
        priorityQueue = new PriorityQueue<DistanceToEdge>(
                graph.getNumberOfVertices());

        for (int v = 0; v < graph.getNumberOfVertices(); v++) {
            distanceTo[v] = Long.MAX_VALUE;
        }
        distanceTo[source] = 0L;

        priorityQueue.offer(new DistanceToEdge(source, 0L));

        while (!priorityQueue.isEmpty()) {
            relax(graph, priorityQueue.poll().getEdge());
        }

    }

    private void relax(DirectedGraph graph, int v) {
        for (DirectedEdge edge : graph.getNeighborhoodList(v)) {
            int w = edge.to();

            if (distanceTo[w] > distanceTo[v] + edge.getWeight()) {
                distanceTo[w] = distanceTo[v] + edge.getWeight();
                edgeTo[w] = edge;
                DistanceToEdge dte = new DistanceToEdge(w, distanceTo[w]);

                priorityQueue.remove(dte);
                priorityQueue.offer(dte);
            }
        }

    }

    public long getDistanceTo(int v) {
        return distanceTo[v];
    }

    public boolean hasPathTo(int v) {
        return distanceTo[v] < Long.MAX_VALUE;
    }

    public Iterable<DirectedEdge> getPathTo(int v) {
        Deque<DirectedEdge> path = new ArrayDeque<DirectedEdge>();
        if (!hasPathTo(v)) {
            return path;
        }
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
