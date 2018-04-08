public class countBits {

    public static void countBits(int i) {
        int parity = 0;
        System.out.print(i + " ");
        while (i>0) {
            //numBits+=(i & 1);
            parity ^= (i & 1);
            i>>>=1;
        }
        System.out.println(parity);
    }

    public static void countBits2(int i) {
        int parity = 0;
        System.out.print(i + " ");
        while (i>0) {
            parity ^= 1;
            //numBits+=(i & 1);
            i &= (i-1);
        }
        System.out.println(parity);
    }

    public static void main(String[] args) {
        countBits2(5);
        countBits2(8);
        countBits2(11);
    }
}
