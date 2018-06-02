public class IntegerValueOf {

    public static void main(String[] args) {
        Integer a = Integer.valueOf(1000);
        Integer b = Integer.valueOf(1000);
        Integer c = new Integer(1000);

        System.out.println(a==b);
        System.out.println(a==c);


        Integer d = Integer.valueOf("3E8", 16);
        System.out.println(a==d);

        Integer x1 = new Integer(1);
        Integer x2 = new Integer(1);
        System.out.println(x1==x2);


    }
}
