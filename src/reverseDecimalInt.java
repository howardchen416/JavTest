public class reverseDecimalInt {

    public static int reverseDecimalInt(int i) {
        int res = 0;
        int div = 10;
        while (i>0) {
            res = res*div + (i%div);
            i /= div;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseDecimalInt(987654321));
    }
}
