import javafx.scene.layout.Priority;

import java.util.PriorityQueue;

public class PriorityQueueTest {


    public static class Node implements Comparable<Node> {
        Integer value;
        String name;

        public Node(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node (6, "f"));
        Node cn = new Node (3, "c");
        q.offer(cn);
        q.offer(new Node (1, "a"));
        q.offer(new Node (8, "h"));
        cn.value = 20;

        System.out.println(q.poll().value);
        System.out.println(q.poll().value);
        System.out.println(q.poll().value);
        System.out.println(q.poll().value);



    }



}
