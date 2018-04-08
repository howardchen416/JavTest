public class ReverseString {

    public static String reverseString(String str) {
        if (str.length()==1)
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(str + " " +  reverseString(str));

    }
}
