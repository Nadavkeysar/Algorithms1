package lecture1;

public class FirstParkingSolution {

    public static void main(String[] args) {

        int len = 1000;

        // create circular linked list with len nodes
        CircularLinkedList list = new CircularLinkedList();
        for(int i = 0; i < len; i++) list.add(i);

        // randomly mark the nodes as W or V
        for(NodeCycle node = list.getHead(); node.next != list.getHead(); node = node.next) {
            double rand = (Math.random());
            if(rand > 0.5) node.m = Mark.V;
        }

        int count = countNodes(list.getHead());
        System.out.print("number of nodes: " + count);
    }

    private static int countNodes(NodeCycle head) {

        // count the nodes
        int count = 0;

        // start from head of nodes - mark it as V
        head.m = Mark.V;
        NodeCycle node = head;

        // go throw all nodes until complete a full rotation
        while(true) {

            System.out.println(node + ", " + node.m);

            // go to next
            node = node.next;
            count++;

            // found node with mark V
            if(node.m == Mark.V) {

                System.out.println(node + ", " + node.m);

                // change it to mark W
                node.m = Mark.W;

                // go back count times
                for(int i = count; i > 0; i--) {
                    System.out.println(node + ", " + node.m);
                    node = node.prev;
                }

                // if node mark is W we got back to head
                if(node.m == Mark.W) return count;

                // if not we go forward count times
                for(int j = 0; j < count; j++) {
                    System.out.println(node + ", " + node.m);
                    node = node.next;
                }
            }
        }
    }
}