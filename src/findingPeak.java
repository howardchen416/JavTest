public class findingPeak {

    private static int findPeak(int[] ar) {
        int l = 0;
        int r = ar.length-1;
        while (l < r) {
            int m = l + (r - l)/2;
            if (m+1<ar.length && ar[m] > ar[m+1]) r = m;
            else if (m+1<ar.length && ar[m] < ar[m+1]) l = m+1;
        }
        return l;

    }

    public static void main(String[] args) {
        //int[] ar = {1, 2, 3, 5, 8, 12, 9, 7, 5};
        //int[] ar = {1, 2, 3, 5, 8, 12, 9};
        int[] ar = {8, 12, 9, 7, 4, 2};
        System.out.println(findPeak(ar));
    }
}
