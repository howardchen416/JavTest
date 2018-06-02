public class StringParsing {

    public static String parse(String str) {
        if (str.indexOf('[')<0) return str;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int repetition = 0;
        while (i<str.length()) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                repetition = repetition*10 + (c-'0');
                i++;
            } else {
                if (c=='[' && repetition!=0) {
                    int nb = findTailIdx(str.substring(i+1)) + i+1;
                    String strToBeRepeated = parse(str.substring(i+1, nb));
                    do {
                        sb.append(strToBeRepeated);
                    } while (--repetition > 0);
                    i=nb+1;
                }
                else { // repetition=0
                    sb.append(c);
                    i++;
                }
            }
        }
        return sb.toString();
    }

    public static int findTailIdx(String str) {
        int count = 0, r=-1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='[') count++;
            else if (str.charAt(i)==']') count--;
            if (count==-1) {
                r = i;
                break;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        //String str = "3[abc]4[ab]c";
        String str = "2[3[a]b]";
        System.out.println(parse(str));
    }
}
