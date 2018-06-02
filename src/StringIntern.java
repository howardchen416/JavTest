public class StringIntern {
    public static void main(String[] args) {
        String a = "abc";
        String a2 = new String("abc");

        System.out.println(a.equals(a2));
        System.out.println(a==a2);

        String a3 = a2.intern();

        System.out.println(a==a3);
        System.out.println(a2==a3);
        //System.out.println(a==a2);

        a += 'd';

        System.out.println(a);
        System.out.println(a==a3);


    }



}
