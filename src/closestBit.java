public class closestBit {
    public static long closestBit(long l) {
        int i = 0;
        long r = 0L;
        while (i < 62 && (l >>> i & 1L) == (l >>> (i + 1) & 1L)) {
            i++;
        }
        if (i < 62) {
            long bitMask = 1L << i | 1L << (i + 1);
            System.out.println("bitMask: " + Long.toBinaryString(bitMask));
            r = l ^ bitMask;
            System.out.println("l: " + Long.toBinaryString(l));
            System.out.println("r: " + Long.toBinaryString(r));
        }
        else {
            throw new IllegalArgumentException("The input is all 0 or 1");
        }
        return l;
    }


    public static void main(String[] args) {
        long l = 0x0L;
        System.out.println(Long.toBinaryString(l));
        System.out.println(Long.toBinaryString(closestBit(l)));

    }
}
