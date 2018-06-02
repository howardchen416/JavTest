import java.util.*;

public class CompressionTest {


    private static class TrieNode {
        private boolean isToken = false;
        private int startPos = -1;
        private Map<Character, TrieNode> leaves = new HashMap<>();
        private TrieNode parent;

        public TrieNode(boolean isToken, int startPos, TrieNode parent) {
            this.isToken = isToken;
            this.startPos = startPos;
            this.parent = parent;
        }

        public boolean isToken() {
            return isToken;
        }

        public void setToken(boolean token) {
            isToken = token;
        }

        public int getStartPos() {
            return startPos;
        }

        public void setStartPos(int startPos) {
            this.startPos = startPos;
        }

        public Map<Character, TrieNode> getLeaves() {
            return leaves;
        }

    }
    // private static TrieNode root = new TrieNode(false, -1);

    public static void insert(TrieNode root, String str, int s, int e) { // j exclusive
        TrieNode p = root;
        for (int i = s; i < e; i++) {
            char c = str.charAt(i);
            if (!p.getLeaves().containsKey(c)) {
                p.getLeaves().put(c, new TrieNode(false, s, p));
            } else if (!p.getLeaves().get(c).isToken() && p.getLeaves().get(c).getStartPos()!=s && 2*s>=p.getLeaves().get(c).getStartPos()+i+1 && i>s) {
                p.getLeaves().get(c).setToken(true);
                System.out.println(str.substring(s, i+1) + " is set to be a token starting at " + p.getLeaves().get(c).getStartPos());
            }
            p = p.getLeaves().get(c);
        }
    }

    public static boolean isToken(TrieNode root, String str, int s, int e) {
        TrieNode p = root;
        for (int i = s; i < e; i++) {
            char c = str.charAt(i);
            if (!p.getLeaves().containsKey(c)) {
                return false;
            }
            p = p.getLeaves().get(c);
        }
        if (p==null || !p.isToken) return false;
        return true;
    }

    public static String longestTokenStartingAt(TrieNode root, String str, int s) {
        TrieNode p = root;
        int i = s;
        int lastTokenPos = 0;
        while (p!=null && i<str.length()) {
            char c = str.charAt(i);
            if (!p.getLeaves().containsKey(c)) break;
            p = p.getLeaves().get(c);
            i++;
            if (p.isToken) { lastTokenPos = i;}
        }
        return str.substring(s, lastTokenPos);
    }

    public static String shortestTokenStartingAt(TrieNode root, String str, int s) {
        TrieNode p = root;
        int i = s;
        int lastTokenPos = 0;
        while (p!=null && i<str.length()) {
            char c = str.charAt(i++);
            if (p.getLeaves().get(c).isToken) break;
            p = p.getLeaves().get(c);
        }
        return str.substring(s, i);
    }

    private static class Token {
        String str;
        int repetitionCount;

        public Token(String str, int repetitionCount) {
            this.str = str;
            this.repetitionCount = repetitionCount;
        }
    }

    public static void main(String[] args) {
        String s = "abababcabcabcabczazaz";

        // build dictionary Trie
        TrieNode root = new TrieNode(false, -1, null);
        TrieNode p = root;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                insert(root, s, j, i);
            }
        }
        // scan str
        Deque<Token> stack = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            //String lT = longestTokenStartingAt(root, s, i);
            String lT = shortestTokenStartingAt(root, s, i);
            if (!stack.isEmpty() && stack.peekFirst().str.equals(lT)) {
                stack.peekFirst().repetitionCount++;
            } else {
                stack.addFirst(new Token(lT, 1));
            }
            i += lT.length();
        }

        System.out.println();
    }

}
