package Controller;

import Model.Car;
import Model.Delivery;
import Model.IOController;
import Model.Map;
import Model.Parcel;
import Model.Graph.DirectedGraph;
import Model.Graph.Dijkstra;

public class MainController {

    public MainController(String[] args) {
        ioc = new IOController();
        dy = new Delivery();
        cr = new Car();
        parcels = new Parcel[1000];
        mp = new Map();
        priority = new int[1000];
        ioc.loadData(args, dy, cr, parcels, mp, priority, graph);
        dy.startDelivery(priority, mp);
    }

    public void sortPriority() {
        quicksort(priority, 0, priority.length);
    }

    private static void quicksort(int tablica[], int x, int y) {

        int i, j, v, temp;

        i = x;
        j = y;
        v = tablica[(x + y) / 2];
        do {
            while (tablica[i] < v) {
                i++;
            }
            while (v < tablica[j]) {
                j--;
            }
            if (i <= j) {
                temp = tablica[i];
                tablica[i] = tablica[j];
                tablica[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (x < j) {
            quicksort(tablica, x, j);
        }
        if (i < y) {
            quicksort(tablica, i, y);
        }
    }

    public void determineDistances() {
        int source = 0;
        Dijkstra shortestPath = new Dijkstra(graph, source);

//        for (int target = 0; target < graph.getNumberOfVertices(); target++) {
//            if (shortestPath.hasPathTo(target)) {
//                System.out.printf("%d do %d (%d)  ", source, target,
//                        shortestPath.getDistanceTo(target));
//                if (shortestPath.hasPathTo(target)) {
//                    for (DirectedEdge edge : shortestPath.getPathTo(target)) {
//                        System.out.print(edge);
//                    }
//                }
//            } else {
//                System.out.printf("%d do %d - brak sciezki  ", source, target);
//            }
//            System.out.println();
//        }
    }
    private int[] priority;
    private int[] distance;
    private IOController ioc;
    private Delivery dy;
    private Car cr;
    private Parcel parcels[];
    private Map mp;
    private DirectedGraph graph;
}
