
package Model.Graph;

public class DirectedEdge {

        private final int from;
        private final int to;
        private final long weight;

        public DirectedEdge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int from() {
            return from;
        }

        public int to() {
            return to;
        }

        public long getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return String.format("%d->%d (%d) ", from, to, weight);
        }
    }
