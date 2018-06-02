import java.util.Deque;
import java.util.LinkedList;

public class StringPattern {

    private static class Pattern {
        int start;
        int end;
        int repeatingTimes;

        public Pattern(int start, int end, int repeatingTimes) {
            this.start = start;
            this.end = end;
            this.repeatingTimes = repeatingTimes;
        }

        public int length() {
            return end - start + 1;
        }
    }

    private static String compress(String str) {
        Deque<Pattern> stack = new LinkedList<>();
        int i = 0;
        while (i < str.length()) {
            boolean patternIdentified = false;
            int startPos = i+1;
            for (int j = i; j >= 0 && startPos+i-j<str.length(); j--) {
                while (startPos+i-j<str.length() && str.substring(j, i+1).equals(str.substring(startPos, startPos+i-j+1))) {
                    if (!patternIdentified) {
                        patternIdentified = true;
                        // pop length worth if patterns from stack and add a new pattern
                        int len = i - j;
                        while (len>0) {
                            Pattern p = stack.pollFirst();
                            if (p.repeatingTimes>1) {
                                p.repeatingTimes--;
                                stack.offerFirst(p);
                            }
                            len -= p.length();
                        }
                        stack.offerFirst(new Pattern(j, i,2));
                    } else {
                        Pattern p = stack.pollFirst();
                        p.repeatingTimes++;
                        stack.offerFirst(p);
                    }
                    startPos += (i-j+1);
                }
                if (patternIdentified) break;
            }
            if (!patternIdentified) stack.offerFirst(new Pattern(i, i, 1));
            i = startPos;
        }

        return "";
    }

    public static void main(String[] args) {
        String str = "abababcabcabcabczazaz";
        compress(str);

    }

}
