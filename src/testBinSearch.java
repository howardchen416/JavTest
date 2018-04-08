import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class testBinSearch {
    public static void testBinSearch() {
        List<Double> l = Arrays.asList(0D, 0.25D, 0.5D, 0.75D, 1D);

        double d = -0.1D;
        int i1 = Collections.binarySearch(l, d);
        System.out.println(i1 + " " + d);
        d = 0.3D;
        i1 = Collections.binarySearch(l, d);
        System.out.println(i1 + " " + d);
        d = 0.6D;
        i1 = Collections.binarySearch(l, d);
        System.out.println(i1 + " " + d);
        d = 0.8D;
        i1 = Collections.binarySearch(l, d);
        System.out.println(i1 + " " + d);
        d = 1.2D;
        i1 = Collections.binarySearch(l, d);
        System.out.println(i1 + " " + d);

    }

    public static void main(String[] args) {
        testBinSearch();
    }
}
