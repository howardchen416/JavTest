public class gcd {

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static int lcm(int x, int y) {
        int a;
        a = (x > y) ? x : y; // a is greater number
        while(true) {
            if(a % x == 0 && a % y == 0)
                return a;
            ++a;
        }
    }


}
