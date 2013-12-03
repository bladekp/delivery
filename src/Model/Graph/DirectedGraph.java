/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {

        private final int v;
        private int e;
        private List<DirectedEdge>[] neighborhoodLists;

        public DirectedGraph(int v) {
            this.v = v;
            this.e = 0;
            this.neighborhoodLists = (List<DirectedEdge>[]) new List[v];
            for (int i = 0; i < v; i++) {
                neighborhoodLists[i] = new ArrayList<DirectedEdge>();
            }
        }

        public int getNumberOfEdges() {
            return e;
        }

        public int getNumberOfVertices() {
            return v;
        }
        public void addEdge(DirectedEdge edge) {
            neighborhoodLists[edge.from()].add(edge);
            e++;
        }
        public Iterable<DirectedEdge> getNeighborhoodList(int v) {
            return neighborhoodLists[v];
        }
    }
