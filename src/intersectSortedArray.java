import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersectSortedArray {

    public static List<Integer> intersectTwoSortedArrays(List<Integer> A, List<Integer> B) {
        List<Integer> r = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) == B.get(j)) {
                if (i==0 || A.get(i)!=A.get(i-1))
                    r.add(A.get(i));
                i++; j++;
            }
            else if (A.get(i) > B.get(i)) {
                j++;
            }
            else { // A.get(i)<B.get(i)
                i++;
            }
        }
        return r;
    }

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1, 2, 2, 3);
        List<Integer> b = Arrays.asList(2, 3, 3, 4);
        List<Integer> r = intersectTwoSortedArrays(a, b);

        System.out.println(r);

    }

}
