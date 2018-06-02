import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecryptionTest {

    private static Map<String, List<String>>  dictionary = new HashMap<>();

    public static void buildDictionary(String[] dictionaryWords) {
        for (String str : dictionaryWords){
            StringBuilder representativeWord = new StringBuilder();
            Map<Character, Integer> charCode = new HashMap<>();
            int numDistinctCharsSoFar = 0;
            for (int i = 0; i<str.length(); i++) {
                Character c = str.charAt(i);
                if (!charCode.containsKey(c))
                    charCode.put(c, numDistinctCharsSoFar++);
                representativeWord.append((char) (charCode.get(c) + 'a'));
            }
            if (!dictionary.containsKey(representativeWord.toString()))
                dictionary.put(representativeWord.toString(), new ArrayList<String>());
            dictionary.get(representativeWord.toString()).add(str);
        }
    }


    public static String findRepresentativeWord(String str) {
        StringBuilder representativeWord = new StringBuilder();
        Map<Character, Integer> charCode = new HashMap<>();
        int numDistinctCharsSoFar = 0;
        for (int i = 0; i<str.length(); i++) {
            Character c = str.charAt(i);
            if (!charCode.containsKey(c))
                charCode.put(c, numDistinctCharsSoFar++);
            representativeWord.append((char) (charCode.get(c) + 'a'));
        }
        return representativeWord.toString();
    }

    static {
        buildDictionary(new String[]{"banana", "door"});
    }

    public static List<String> findDecryptionCandidates(String str) {
        String representativeWord = findRepresentativeWord(str);
        return dictionary.get(representativeWord);
    }

    public static void main(String[] args) {
        System.out.println(findDecryptionCandidates("togogo").get(0));
        System.out.println(findDecryptionCandidates("baat").get(0));

    }
}
