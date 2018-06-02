public class Power {
    public static double power(double x, int y) {
        double r = 1.0;

        while (y!=0) {
            if ((y & 1L) != 0)
                r *= x;
            x *= x;
            y>>>=1;
        }
        return r;
    }

    public static void main(String[] args) {
        double x = 1.1;
        int y = 4;
        System.out.println("x=" + x + " y=" + y + " result=" + power(x, y));
    }

}
