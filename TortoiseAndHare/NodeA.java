package TortoiseAndHare;

public class NodeA {
    int data;
    NodeA prev, next = null;

    public NodeA() {

    }

    public NodeA(int data, NodeA prev, NodeA next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public NodeA(int c) {
        this.data = c;
    }

    public String toString() {
        return "" + this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(NodeA next) {
        this.next = next;
    }

    public void setPrev(NodeA prev) {
        this.prev = prev;
    }

    public int getData() {
        return this.data;
    }

    public NodeA getNext() {
        return this.next;
    }

    public NodeA getPrev() {
        return this.prev;
    }
}
