public class revBits {

    public static void revBits(long l) {
        long bitMask = 65535L;
        int wordLength = 16;
/*        return precomputedReverse(l>>>3*wordLength & bitMask |
        precomputedReverse(l>>>2*wordLength & bitMask) << 1*wordLength |
        precomputedReverse(l>>>1*wordLength & bitMask) << 2*wordLength |
        precomputedReverse(l & bitMask) << 3*wordLength);*/
    }

    public static long precomputedReverse(long l) {
return 1L;
    }

    public static void main(String[] args) {

    }
}
