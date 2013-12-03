/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Graph;

public class DistanceToEdge implements Comparable {
        private final int edge;
        private long distance;

        public DistanceToEdge(int edge, long distance) {
            this.edge = edge;
            this.distance = distance;
        }

        public long getDistance() {
            return distance;
        }

        public void setDistance(long distance) {
            this.distance = distance;
        }

        public int getEdge() {
            return edge;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (distance ^ (distance >>> 32));
            result = prime * result + edge;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            DistanceToEdge other = (DistanceToEdge) obj;
            if (distance != other.distance) {
                return false;
            }
            if (edge != other.edge) {
                return false;
            }
            return true;
        }
    @Override
    public int compareTo(Object o) {
        int cmp = new Long(distance).compareTo(((DistanceToEdge) o).getDistance());

            if (cmp == 0) {
                return new Integer(edge).compareTo(((DistanceToEdge) o).getEdge());
            }
            return 0;
    }
    }
