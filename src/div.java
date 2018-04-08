public class div {
    public static long div(long i, long j) {
        long power = 0;
        int quotient = 0;
        while ((j<<power) >0) { power++; }
        power--; // largest shifted j without overflow
        long jPower = j<<power;
        while (i>j) {
            while (jPower>i) {
                jPower>>>=1;
                power--;
            }
            i -= jPower;
            quotient+=1L<<power;
        }
        return quotient;
    }

    public static void main(String[] args) {
        long i = 34587648;
        long j = 5;
        System.out.println(div(i, j));
    }
}
