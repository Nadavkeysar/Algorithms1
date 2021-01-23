package practice;

public class MyLinkedList {
    private NodeLinkedList head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public NodeLinkedList getHead() { return this.head; }

    public int getSize() { return this.size; }

    public void add(int data) {
        if(this.head == null) this.head = new NodeLinkedList(data);
        else {
            NodeLinkedList n = this.head;
            while(n.next != null) n = n.next;
            n.next = new NodeLinkedList(data);
        }
        this.size++;
    }

    public NodeLinkedList getByIndex(int index) {
        if(index > this.size) return null;
        else {
            NodeLinkedList node = this.head;
            int i = 0;
            while(i < index) {
                node = node.next;
                i++;
            }
            return node;
        }
    }

    public String toString() {
        String ans = "[";
        NodeLinkedList node = this.head;
        int i = 0;
        while(i < this.size) {
            ans += node;
            if(i != this.size - 1) ans += ", ";
            node = node.next;
            i++;
        }
        return ans + "]";
    }
}
