public class lowLevelMultiply {

    public static long lowLevelMultiply(long i, long j) {
        long result = 0L;
        int c = 0;
        while ((j>>>=1) !=0) {
            c++;
            long l = ((j & 1L) != 0L) ? (i<<c) : 0L;
            result += l;
        }
        return result;
    }
    public static void main(String[] args) {
        long i = 5;
        long j = 8;
        System.out.println(lowLevelMultiply(i, j));
    }
}
