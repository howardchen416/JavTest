public class bitSwapping {

    public void bitSwapping(long l, int i, int j) {
        if (((l>>>i) &1) != ((l>>>j &1))) {
            long bitMask = (1L << i) | (1L << j);
            l ^= bitMask;
        }

    }

    public static void main(String[] args) {

    }
}
