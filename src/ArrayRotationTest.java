import java.util.*;

public class ArrayRotationTest {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4};
        //Arrays.asList(a);
        Collections.rotate(Arrays.asList(a), 2);

        Collections.rotate(Arrays.asList(a), 1);

    }
}
