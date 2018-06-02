import java.util.*;

public class RunningMode {

    public static int calculateMode(Map<Integer, Integer> m, int currMode, int c) {
        if (!m.containsKey(c)) m.put(c, new Integer(0));
        m.put(c, m.get(c)+1);
        if (m.get(currMode)<m.get(c)) return c;
        else if (m.get(currMode)==m.get(c)) return (currMode>=c) ? c : currMode;
        else { // (m.get(currMode)>m.get(c)
            return currMode;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> m = new HashMap<>();
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }

        m.put(ar[0], 1);
        int cM = ar[0];
        for (int i = 1; i < n; i++) {
            cM = calculateMode(m, cM, ar[i]);
            System.out.println(cM);
        }

    }
}
