public class lowLevelMultiply {

    public static long lowLevelMultiply(long i, long j) {
        long result = 0L;
        while (i != 0) {
            if ((i & 1L) != 0L) result = add(result, j);
            i >>>= 1;
            j <<= 1;
        }
        return result;
    }

    public static long add(long a, long b) {
        long k = 1L;
        long carryin = 0L;
        long at= a, bt = b;
        long sum = 0L;
        while (at!=0 || bt!=0) {
            long ak = a & k;
            long bk = b & k;
            long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
            sum |= ak ^ bk^ carryin;
            carryin = carryout << 1;
            k <<= 1;
            at>>>=1;
            bt>>>=1;
        }
        return sum;
    }

    public static void main(String[] args) {
        long i = 5;
        long j = 8;
        System.out.println(lowLevelMultiply(i, j));
    }
}
