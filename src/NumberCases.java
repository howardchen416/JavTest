public class NumberCases {

    public static void main(String[] args) {
        /*Double a = 1.0;
        Double b = 0.0;

        Double c = a / b;

        Double d = Double.valueOf(b / b);

        Double e = Double.valueOf(b / b);

        System.out.println(d);
        System.out.println(e);
        System.out.println(d == e);
        System.out.println(d.equals(e));
        System.out.println(d.compareTo(e));

        System.out.println(Math.min(Float.MIN_VALUE, 0.0f));

        byte by = 0x00000000;
        byte by1 = 0x00000001;

        System.out.println(by);
        System.out.println(++by);
        System.out.println(by+=1);

        byte by2 = (byte) (by + by1);

        System.out.println(by2);
*/

        int b1 = -16;
        String s1 = String.format("%32s", Integer.toBinaryString(b1)).replace(' ', '0');
        System.out.println(s1);
 /*       String s1 = Integer.toBinaryString(b1);
        System.out.println(s1.replace(' ', '0')); // 10000001
 */
        int b2 = (b1 >>> 2);
        String s2 = String.format("%d", b2);
        System.out.println(s2);

        byte b3 = (byte) 134;
        String s3 = String.format("%32s", Integer.toBinaryString(b3)).replace(' ', '0');
        System.out.println(s3);

        byte b4 = (byte) (b1 + b3);
        System.out.println(b4);
        String s4 = String.format("%32s", Integer.toBinaryString(b4)).replace(' ', '0');
        System.out.println(s4);


    }

}
