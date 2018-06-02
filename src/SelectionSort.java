import java.util.Arrays;
import java.util.Collections;

public class SelectionSort {

    public static void selectionSort(Integer[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for (int j = i; j < a.length; j++) {
                if (a[j] < minValue) {
                    minValue = a[j];
                    minIndex = j;
                }
            }
            Collections.swap(Arrays.asList(a), i, minIndex);
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        Integer[] a = {4, 2, 9, 15, 1, 7};
        selectionSort(a);
    }
}
