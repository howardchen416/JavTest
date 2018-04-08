import java.util.HashMap;

public class findDupCharsInString {

    public static void findDupCharsInString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charAry = str.toCharArray();
        for (char c : charAry) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }

        }
        for (char c : map.keySet()) {
            if ((map.get(c)) > 1) {
                System.out.print(c + ":" + map.get(c) + " ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "sktrgqsbdekhhrirqeiur";
        findDupCharsInString(str);
        //System.out.println(str + " " +  findDupCharsInString(str));

    }
}

