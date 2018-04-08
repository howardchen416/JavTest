public class listZipping {

    public static class ListNode<S> {
        public ListNode(S s, ListNode next) { _nodeContent = s; _next = next; }
        ListNode _next;
        S _nodeContent;
    }

    static void listZipping(ListNode<Integer> listHead) {
        // find 2nd half
        ListNode<Integer> slow=listHead, fast=listHead;
        while (fast!= null && fast._next!=null) {
            slow=slow._next;
            fast=fast._next._next;
        }

        ListNode<Integer>secondHalfHead = slow._next;
        // split the list
        slow._next = null;

        ListNode<Integer> reversedSecondHalfHead = reverseList(secondHalfHead);
        ListNode<Integer> p1 = listHead;
        ListNode<Integer> p2 = reversedSecondHalfHead;

        // create zip
        while (p2!=null) {
            ListNode<Integer> t1 = p1._next;
            ListNode<Integer> t2 = p2._next;
            p1._next=p2;
            p2._next=t1;
            p1=t1;
            p2=t2;
        }

        listZipping.printList(listHead);
    }

    static void printList(ListNode<Integer> listHead) {
        ListNode<Integer> p = listHead;
        while (p!=null) {
            System.out.println(p._nodeContent+ ":");
            p=p._next;
        }
    }

    static ListNode<Integer> reverseList(ListNode<Integer> listHead) {
        ListNode<Integer> t = null;
        ListNode<Integer> t2 = null;
        ListNode<Integer> c = listHead;
        while (c!=null) {
            t2 = c._next;
            c._next=t;
            t=c;
            c=t2;
        }
        return t;
    }

    public static void main(String[] args) {
        ListNode<Integer> l4 = new ListNode<>(4, null);
        ListNode<Integer> l3 = new ListNode<>(3, l4);
        ListNode<Integer> l2 = new ListNode<>(2, l3);
        ListNode<Integer> l1 = new ListNode<>(1, l2);
        ListNode<Integer> l0 = new ListNode<>(0, l1);
        ListNode<Integer> listHead = l0;

        listZipping(listHead);
        //ListNode<Integer> l5 = new ListNode<>(5);
    }
}
