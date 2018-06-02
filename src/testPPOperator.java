public class testPPOperator {

    public static void main(String[] args) {
        int i = 0;
        int a = ++i;
        int j = 0;
        int b = j++;
        System.out.println("i:" + i + " a:" + a + " j:" + j + " b:" + b);
        for (int k = 0; k < 5; k++) {
            System.out.println("k:" + k + " ");
        }
        for (int k = 0; k < 5; ++k) {
            System.out.println("k:" + k + " ");
        }
    }
}
