public class palindromic {

    public static boolean palindromic(long i) {
       // long res = 0L;
        if (i<0) return false;
        else if (i==0) return true;

        int numDigits = (int) Math.log10(i) + 1;
        int hiDiv = (int) Math.pow(10, numDigits-1);
        int loDiv = 10;

        while (hiDiv>0 && hiDiv>=loDiv && i/hiDiv==i%loDiv) {
            i%=hiDiv; // cut high digit
            i/=loDiv; // cut low digit
            hiDiv/=100;
        }

        if (hiDiv>0 && i/hiDiv!=i%loDiv) return false;

        return true;
    }

    public static void main(String[] args) {
        int i = 3122453;
        System.out.println(i + " " + palindromic(i));
        i = 1234321;
        System.out.println(i + " " + palindromic(i));
        i = 3579753;
        System.out.println(i + " " + palindromic(i));
        i = 1221;
        System.out.println(i + " " + palindromic(i));

    }
}
