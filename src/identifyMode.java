import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class identifyMode {

    public static void identifyMode(int[] ints) {
        Map<Integer, Integer> m = new HashMap<>();
        int largestCount = Integer.MIN_VALUE;
        int mode = 0;
        for (int i : ints) {
            if (!m.containsKey(i)) {
                m.put(i, 0);
            }
            m.put(i, m.get(i)+1);
            if (m.get(i)>largestCount) {
                largestCount = m.get(i);
                mode = i;
            }
        }
        System.out.print("LC: " + largestCount + " Mode: " + mode);
    }

    public static void main(String[] args) {
        int[] ints = {13, 18, 13, 14, 13, 16, 14, 21, 13};
        identifyMode(ints);
    }
}
