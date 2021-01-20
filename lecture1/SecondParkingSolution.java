package lecture1;

public class SecondParkingSolution {

    public static void main(String[] args) {

        int len = 10000;

        // create circular linked list with len nodes
        CircularLinkedList list = new CircularLinkedList();
        for(int i = 0; i < len; i++) list.add(i);

        int count = countNodes(list.getHead());
        System.out.print("number of nodes: " + count);
    }

    private static int countNodes(NodeCycle head) {

        NodeCycle a = head.next; // going forward
        int count1 = 1;
        NodeCycle b = head; // going backward
        int count2 = 1;

        while(a.next != b) {
            System.out.println("a is in: " + a);
            a = a.next;
            count1++;

            System.out.println("b is in: " + b);
            b = b.prev;
            count2++;

        }
        System.out.println("a and b mit in: " + count2);
        return count1 + count2;
    }
}
