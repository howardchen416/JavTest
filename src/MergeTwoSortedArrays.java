import java.util.List;

public class MergeTwoSortedArrays {
    public static List<Integer> MergeTwoSortedArrays(List<Integer> a, int m, List<Integer> b, int n) {
        int writeIdx = m + n - 1;
        m--;
        n--;
        while (m>=0 && n>=0) {
            a.set(writeIdx--, (a.get(m)>b.get(n)) ? a.get(m--) : b.get(n--));
        }
        while (n>=0)
            a.set(writeIdx--, b.get(n--));
        return a;
    }

}
