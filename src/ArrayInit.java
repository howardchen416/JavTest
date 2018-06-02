public class ArrayInit {
    public static void main(String[] args) {
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

        int[][] b = new int[5][4];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.println("b[" + i + "][" + j + "]=" + b[i][j]);
            }

        }
    }
}
