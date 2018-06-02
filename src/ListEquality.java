import java.util.*;

public class ListEquality {

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 2, 3);
        List<Integer> l2 = Arrays.asList(1, 2, 3, 2);
        Collections.sort(l2);
        System.out.println("L1 L2 " + l1.equals(l2));
        List<Integer> l3 = Arrays.asList(1, 2, 2, 3);
        System.out.println("L1 L3 " + l1.equals(l3));
        List<Integer> l4 = Collections.emptyList();
        List<Integer> l5 = Collections.emptyList();
        System.out.println("L4 L5 " + l4.equals(l5));

        Set<List<Integer>> s = new HashSet<>();
        s.add(l1);
        s.add(l2);
        System.out.println(s);
    }
}
