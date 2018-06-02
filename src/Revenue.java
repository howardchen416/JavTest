import java.util.List;

public class Revenue {

    public static int computeMaxRevenue(List<Integer> coins) {
        return computeMaxRevenueHelper(coins, 0, coins.size(), new int[coins.size()][coins.size()]);
    }

    public static int computeMaxRevenueHelper(List<Integer> coins, int left, int right, int[][] r) {
        // base case
        if (left > right) {
            return 0;
        }

        if (r[left][right]==0) {
            int A = coins.get(left) + Math.min(computeMaxRevenueHelper(coins, left+2, right, r),
                    computeMaxRevenueHelper(coins, left+1, right-1, r));
            int B = coins.get(right) + Math.min(computeMaxRevenueHelper(coins, left+1, right-1, r),
                    computeMaxRevenueHelper(coins, left, right-2, r));
            r[left][right] = Math.max(A, B);
        }
        return r[left][right];
    }

    public static void main(String[] args) {

    }
}
