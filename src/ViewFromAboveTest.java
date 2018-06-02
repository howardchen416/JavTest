import java.util.*;

public class ViewFromAboveTest {
    private class Segment implements Comparable<Segment> {
        int left;
        int right;
        int color;
        int height;

        public Segment(int left, int right, int color, int height) {
            this.left = left;
            this.right = right;
            this.color = color;
            this.height = height;
        }

        @Override
        public int compareTo(Segment o) {
            return this.height - o.height;
        }
    }

    private static class Endpoint implements Comparable<Endpoint> {
        boolean isLeft;
        Segment line;

        public Endpoint(boolean isLeft, Segment line) {
            this.isLeft = isLeft;
            this.line = line;
        }

        public int value() {
            return (isLeft) ? line.left : line.right;
        }

        @Override
        public int compareTo(Endpoint o) {
            return this.value() - o.value();
        }
    }

    public List<Segment> calculateViewFromAbove(List<Segment> segments) {
        List<Endpoint> sortedEndpoints = new ArrayList<>();
        for (Segment segment : segments) {
            sortedEndpoints.add(new Endpoint(true, segment));
            sortedEndpoints.add(new Endpoint(false, segment));
        }
        Collections.sort(sortedEndpoints);

        List<Segment> result = new ArrayList<>();
        int prevX = sortedEndpoints.get(0).value();
        SortedMap<Integer, Segment> activeSegments = new TreeMap<>();
        Segment prev = null;
        for (Endpoint ep : sortedEndpoints) {
            if (!activeSegments.isEmpty() && prevX != ep.value()) {
                if (prev == null) {
                    prev = new Segment(prevX, ep.value(),
                            ((TreeMap<Integer, Segment>) activeSegments).lastEntry().getValue().height,
                            ((TreeMap<Integer, Segment>) activeSegments).lastEntry().getValue().color);
                }
                else if (prev.height == ((TreeMap<Integer, Segment>) activeSegments).lastEntry().getValue().height
                        && prev.color == ((TreeMap<Integer, Segment>) activeSegments).lastEntry().getValue().color
                        && prev.right == prevX) { // prev is extensible
                    prev.right = ep.value();
                }
                else { // prev is not extensible
                    result.add(prev);
                    prev = new Segment(prevX, ep.value(),
                            ((TreeMap<Integer, Segment>) activeSegments).lastEntry().getValue().color,
                            ((TreeMap<Integer, Segment>) activeSegments).lastEntry().getValue().height);
                }
            }
            prevX = ep.value();

            if (ep.isLeft) {
                activeSegments.put(ep.line.height, ep.line);
            }
            else {
                activeSegments.remove(ep.line.height);
            }
        }

        if (prev!=null) {
            result.add(prev);
        }
        return result;
    }
}
