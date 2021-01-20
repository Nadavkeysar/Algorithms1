package TortoiseAndHare;

public class LinkedListCycle {
    NodeA head, tail;
    int size;

    public LinkedListCycle() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void add(int c) {
        // connect head with new tail again
        if (this.head == null) { //if the head is empty
            head = new NodeA(c); //well create a new Node
            this.tail = this.head; // we'll set the head to be tail as well
            this.head.setNext(tail); // define next and prev to be tail
        } else {
            NodeA n = new NodeA(c, tail, head); // if the list is not empty
            tail.setNext(n); // well  put it at the end of the list
            tail = n; // make tail the new node
        }
        this.head.setPrev(tail);
        this.size++; // one more car
    }

    public NodeA getHead() {
        return this.head;
    }

    public NodeA getTail() {
        return this.tail;
    }

    public NodeA getNext(NodeA n) {
        return n.getNext();
    }

    public String toString() {
        StringBuilder s = new StringBuilder("[");
        if (head != null) {
            s.append(head.toString()).append(", ");
            for (NodeA n = head.getNext(); n != head; n = n.getNext()) {
                s.append(n.toString()).append(", ");
            }
            s = new StringBuilder(s.substring(0, s.length() - 2));
        }
        return s + "]";
    }

    public int getSize() {
        return this.size;
    }
}
