import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashTableTest {
    private static class ob {
        int a;
        int b;

        public ob(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ob ob = (ob) o;
            return a == ob.a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a);
        }
    }

    public static void main(String[] args) {
        Map<ob, Integer> map = new HashMap<>();

        ob ob1 = new ob(1, 5);
        map.put(ob1,1);
        map.put(new ob(2, 6), 2);
        map.put(new ob(3, 7), 3);
        ob1.b = 4;
        System.out.println(map.containsKey(ob1));



    }

}
