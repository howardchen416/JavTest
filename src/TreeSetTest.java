import javafx.scene.layout.Priority;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {


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

        SortedSet<Node> q = new TreeSet<>();
        q.add(new Node (6, "f"));
        Node cn = new Node (20, "c");
        q.add(cn);
        q.add(new Node (1, "a"));
        q.add(new Node (8, "h"));
        //cn.value = 20;

        System.out.println(((TreeSet<Node>) q).pollFirst().value);
        System.out.println(((TreeSet<Node>) q).pollFirst().value);
        System.out.println(((TreeSet<Node>) q).pollFirst().value);
        System.out.println(((TreeSet<Node>) q).pollFirst().value);



    }



}
