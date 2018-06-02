import java.util.List;

public class PairSumK {

    private static class IndexPair {
        public Integer indexl;
        public Integer index2;

        public IndexPair(Integer indexl, Integer index2) {
            this.indexl = indexl;
            this.index2 = index2;
        }
    }

    private static interface BooleanCompare {
        public boolean compare(Integer index1, Integer index2);
    }

    private static class CompareLess implements BooleanCompare {
        @Override
        public boolean compare(Integer ol, Integer o2) {
            return ol < o2;
        }

        public static final CompareLess LESS = new CompareLess();
    }

    private static class CompareGreaterEqual implements BooleanCompare {
        @Override
        public boolean compare(Integer ol, Integer o2) {
            return ol >= o2;
        }

        public static final CompareGreaterEqual GREATER_OR_EQUAL
                = new CompareGreaterEqual();
    }

    private static IndexPair findPairUsingComp(List<Integer> A, int k, BooleanCompare comp) {
        IndexPair result = new IndexPair(0, A.size()-1);
        while(result.indexl<A.size() && comp.compare(A.get(result.indexl), 0)) {
            result.indexl++;
        }
        while(result.index2>=0 && comp.compare(A.get(result.index2), 0)) {
            result.index2--;
        }
        while (result.indexl < result.index2)
        if (A.get(result.indexl) + A.get(result.index2) == k) {
            return result;
        }
        else if (comp.compare(A.get(result.indexl) + A.get(result.index2), k)) {
            do {
                result.index2--;
            } while(result.index2>=0 && comp.compare(A.get(result.index2), 0));
        }
        return null;
    }
}
