import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TrieTest {
    public static String findShortestPrefix(String s, Set<String> D) {
// Builds a trie according to given dictionary D.
        Trie T = new Trie();
        for (String word : D) {
            T.insert(word);
        }
        return T.getShortestUniquePrefix(s);
    }
    public static class Trie {

        private static class TrieNode {
            private boolean isString = false;
            private Map<Character, TrieNode> leaves = new HashMap<>();

            public boolean getlsString() { return isString; }
            public void setIsString(boolean string) { isString = string; }
            public Map<Character , TrieNode> getLeaves() { return leaves; }
        }

        private TrieNode root = new TrieNode();

        public boolean insert(String s){
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(!p.getLeaves().containsKey(c)){
                    p.getLeaves().put(c, new TrieNode());
                }
                p = p.getLeaves().get(c);
            }
            // s already existed in this trie.
            if (p.getlsString()){
                return false;
            } else { // p.getlsString() == false
                p.setIsString(true); // Inserts s into this trie.
                return true ;
            }
        }

        public String getShortestUniquePrefix(String s){
            TrieNode p = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                prefix.append(c);
                if(!p.getLeaves().containsKey(c)){
                    return prefix.toString();
                }
                p = p.getLeaves().get(c);
            }
            return "";
        }
    }
}
