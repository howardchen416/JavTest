public class expo {

    public static long exp(long x, int y) {
        long res=1L;
        short power = 0;
        long[] cacheMatrix = new long[16];
        cacheMatrix[0]=x;
        //while ()
        while (y>0) {
            if (power>0) cacheMatrix[power] = selfMultiply(cacheMatrix[power-1]);
            if ((y&1)>0) { res *= cacheMatrix[power]; }
            power++;
            y>>>=1;
        }
        return res;
    }

    public static long selfMultiply(long l) {
     //long res=0L;
     return l*l;
    }

    public static void main(String[] args) {
        System.out.println(exp(8, 3));
    }
}
