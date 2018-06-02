import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class removeElementsInSLL {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    /*
     * Complete the removeNodes function below.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode removeNodes(SinglyLinkedListNode listHead, int x) {

        SinglyLinkedListNode p = null;
        SinglyLinkedListNode i = listHead;
        while (i!=null) {
            if (i.data > x) {
                if (p==null) {
                    listHead = i.next;
                    //p = i.next;
                }
                else {
                    p.next = i.next;
                }
            }
            else p = i;
            i = i.next;

        }

        return listHead;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList listHead = new SinglyLinkedList();

        int listHeadCount = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int listHeadItr = 0; listHeadItr < listHeadCount; listHeadItr++) {
            int listHeadItem = scanner.nextInt();
            //   scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            listHead.insertNode(listHeadItem);
        }

        int x = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        SinglyLinkedListNode res = removeNodes(listHead.head, x);

        printSinglyLinkedList(res, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

