public class IntOverflowTest {

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;

        System.out.println(i);
        System.out.println(i+1);
        System.out.println(i+2);
        System.out.println(-1*i);
    }
}
