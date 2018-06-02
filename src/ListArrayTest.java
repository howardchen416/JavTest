import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListArrayTest {


    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        Integer[] b = {1, 2, 2, 3};
        Integer[] c = {1, 2, 2, 3, 4};

        List<Integer> aL = Arrays.asList(a);
        List<Integer> bL = Arrays.asList(b);
        List<Integer> cL = Arrays.asList(c);

        List<Integer> dL = Stream.of(1, 2, 2, 3).collect(Collectors.toList());
        List<Integer> eL = Stream.of(1, 2, 3).collect(Collectors.toList());
        List<Integer> fL = Stream.of(2, 2, 3, 4).collect(Collectors.toList());

        eL.retainAll(dL);
        //gL.retainAll(eL);
        //gL.retainAll(eL);

        //System.out.println("aL contains all b: " + aL.containsAll(bL));
        //System.out.println("bL contains all a: " + bL.containsAll(aL));
        //System.out.println("bL contains all c: " + bL.containsAll(cL));
        System.out.println("cL contains all b: " + cL.containsAll(bL));


    }
}
