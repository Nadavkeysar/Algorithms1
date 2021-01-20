package TortoiseAndHare;


public class myLinkedList {
    NodeA head, tail;
    int size;

    public myLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void add(int c) {
        // connect head with new tail again
        if (this.head == null) { //if the head is empty
            tail = head = new NodeA(c); //well create a new Node
        } else {
            NodeA n = new NodeA(c); // if the list is not empty
            n.setPrev(tail);
            tail.setNext(n); // well  put it at the end of the list
            tail = n; // make tail the new node
        }
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
            for (NodeA n = head.getNext(); n != null && n!=head; n = n.getNext()) {
                s.append(n.toString()).append(", ");
            }
            s = new StringBuilder(s.substring(0, s.length() - 2));
        }
        return s + "]";
    }

    public int getSize() {
        return this.size;
    }

    public void addNode(NodeA n) {
        tail.setNext(n); // well  put it at the end of the list
        tail = n; // make tail the new node
    }

}


