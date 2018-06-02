import java.util.*;

public class Dijkstra {
    private static class VertexWithDistance {
        public GraphVertex vertex;
        public Integer distance;

        public VertexWithDistance(GraphVertex vertex, Integer distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private static class DistanceWithFewestEdges {
        public Integer distance;
        public Integer minNumEdges;

        public DistanceWithFewestEdges(Integer distance, Integer minNumEdges) {
            this.distance = distance;
            this.minNumEdges = minNumEdges;
        }
    }

    public static class GraphVertex implements Comparable<GraphVertex> {
        public DistanceWithFewestEdges distanceWithFewestEdges
                = new DistanceWithFewestEdges(Integer.MAX_VALUE, 0);
        public List<VertexWithDistance> edges = new ArrayList<>();
        public int id; // The id of this vertex.
        public GraphVertex pred = null; // The predecessor in the shortest path.

        @Override
        public int compareTo(GraphVertex o) {
            if (distanceWithFewestEdges.distance
                    != o.distanceWithFewestEdges.distance) {
                return Integer.compare(distanceWithFewestEdges.distance,
                        o.distanceWithFewestEdges.distance);
            }
            if (distanceWithFewestEdges.minNumEdges
                    != o.distanceWithFewestEdges.minNumEdges) {
                return Integer.compare(distanceWithFewestEdges.minNumEdges,
                        o.distanceWithFewestEdges.minNumEdges);
            }
            return Integer.compare(id, o.id);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof GraphVertex)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            GraphVertex that = (GraphVertex) obj;
            return id == that.id
                    && distanceWithFewestEdges.distance.equals(
                    that.distanceWithFewestEdges.distance)
                    && distanceWithFewestEdges.minNumEdges.equals(
                    that.distanceWithFewestEdges.minNumEdges);
        }

        @Override
        public int hashCode() {
            return Objects.hash(distanceWithFewestEdges.distance,
                    distanceWithFewestEdges.minNumEdges);
        }
    }

    public static void dijkstraShortestPath(GraphVertex s, GraphVertex t) {
        SortedSet<GraphVertex> q = new TreeSet<>();
        q.add(s);

        while (!q.isEmpty()) {
            if (q.first().equals(t))
                break;
        }
        GraphVertex cv = ((TreeSet<GraphVertex>) q).pollFirst();
        for(VertexWithDistance edge : cv.edges) {
            // relax
            int distance = cv.distanceWithFewestEdges.distance + edge.distance;
            int numEdges = cv.distanceWithFewestEdges.minNumEdges + 1;
            if (distance < edge.vertex.distanceWithFewestEdges.distance ||
                    (distance == edge.vertex.distanceWithFewestEdges.distance &&
                            numEdges < edge.vertex.distanceWithFewestEdges.minNumEdges)) {
                q.remove(edge.vertex);
                edge.vertex.distanceWithFewestEdges = new DistanceWithFewestEdges(distance, numEdges);
                edge.vertex.pred = cv;
                q.add(edge.vertex);
            }
        }
    }
}
