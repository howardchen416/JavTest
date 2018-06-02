public class numWaysToTop {

    public static int numWaysToTop(int n, int k) {
        return numWaysToTopHelper(n, k, new int[n+1]);
    }

    public static int numWaysToTopHelper(int n, int k, int[] m) {
        // base condition
        if (n<=1) return 1;

        int sum = 0;
        if (m[n]==0) {
            for (int i = 1; i <= k && n-i >= 0; i++) {
                sum += numWaysToTopHelper(n-i, k, m);
            }
            m[n] = sum;
        }
        return m[n];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                System.out.println("i:" + i + " j:" + j + " ways: " + numWaysToTop(i, j));
            }
        }
    }
}
