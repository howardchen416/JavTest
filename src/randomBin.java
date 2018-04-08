import java.util.Random;

public class randomBin {

    public static int randomBin(int i) {
        int res = 0;
        do {
            int power=0;
            res = 0;

            while ((1L<<power) < i) {
                res<<=1;
                res += coinToss();
                power++;
            }
        } while (res>i);
        return res;
    }

    public static int coinToss() {
        return (int) Math.round(new Random().nextFloat());
    }

    public static void main(String[] args) {
/*        System.out.println(coinToss());
        System.out.println(coinToss());
        System.out.println(coinToss());
        System.out.println(coinToss());
        System.out.println(coinToss());*/
        System.out.println(randomBin(7));
        System.out.println(randomBin(7));
        System.out.println(randomBin(7));
        System.out.println(randomBin(7));
        System.out.println(randomBin(7));
        System.out.println(randomBin(7));

    }
}
