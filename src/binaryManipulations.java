public class binaryManipulations {

    static void binaryManipulations(int i) {
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        int j = i << 27;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        j = i << 28;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        j = i << 29;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        j = i << 30;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        j = i << 31;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        j = i << 32;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
    }

    static void binaryManipulations2(int i) {
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        int j = i >>> 1;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        j = i >>> 2;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        j = i >>> 3;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        j = i >>> 4;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
    }

    static void printBinary(int i) {
        String format="%o32d";
        System.out.printf(format, Integer.valueOf(Integer.toBinaryString(i)));
        System.out.println();
    }

    public static String intToBinary(int n, int numOfBits) {
        String binary = "";
        if (n<0) binary = "1" + binary;
        else binary = "0" + binary;
        for(int i = 1; i < numOfBits; ++i, n/=2) {
            switch (n % 2) {
                case 0:
                    binary = "0" + binary;
                    break;
                case 1:
                    binary = "1" + binary;
                    break;
            }
        }
        System.out.println(binary);
        return binary;
    }

    public static void main(String[] args) {
        binaryManipulations2(-5);
    }
}
