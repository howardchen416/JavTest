import java.util.*;

public class DijkstraPriorityQueue {
    private int distances[];
    private Set<Node> settled;
    private PriorityQueue<Node> priorityQueue;
    private int number_of_nodes;
    private int adjacencyMatrix[][];

    public static int findShortestDistance(Node from, Node to) {
        Queue<Node> toVisit = new PriorityQueue<>();
        toVisit.add(from); // We have to populate the queue at the start. Thanks to nclark for pointing this out to me.

        while (!toVisit.isEmpty()) {
            Node min = toVisit.remove();
            if (min == to) {
                return min.getDistanceFromSource();
            }
            if (min.isVisited()) {
                continue;
            }
            min.setVisited(true);
            for (Map.Entry<Node, Integer> neighborEntry : min.getNeighborList().entrySet()) {
                int adjacentDistance = min.getDistanceFromSource() + neighborEntry.getValue();
                Node neighbor = neighborEntry.getKey();
                if (neighbor.getDistanceFromSource() > adjacentDistance && !neighbor.isVisited()) {
                    neighbor.setDistanceFromSource(adjacentDistance);
                    toVisit.add(neighbor);
                }
            }
        }

        throw new RuntimeException("'to' node unreachable");
    }

    public static void main(String... arg) {

    }

    public static class Node implements Comparable<Node> {

        private final char label;
        private int distanceFromSource;
        private final Map<Node, Integer> neighbourList;
        private boolean visited;

        public Node(char label, int distanceFromSource) {
            this.label = label;
            this.distanceFromSource = distanceFromSource;
            this.neighbourList = new LinkedHashMap<>();
            this.visited = false;
        }

        public void addNeighbourer(Node node, int distance) {
            neighbourList.put(node, distance);
        }

        public char getLabel() {
            return label;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public Map<Node, Integer> getNeighborList() {
            return neighbourList;
        }

        public int getDistanceFromSource() {
            return distanceFromSource;
        }

        public void setDistanceFromSource(int distanceFromSource) {
            this.distanceFromSource = distanceFromSource;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.getDistanceFromSource(), o.getDistanceFromSource());
        }
    }
}