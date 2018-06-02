public class Test {

    static int a = 1111;

    static {
        a = a-- - --a;
    };

    static { a = a++ + ++a; };


    public static void main(String[] args) {
        System.out.println(a);
    }
}
