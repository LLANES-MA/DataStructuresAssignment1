public class Queue<Item> {

    private Node front = null;
    private Node rear = null;

    private class Node
    {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }
    public boolean isEmpty() {
        return (front == null && rear == null);
    }
    public void add(Item item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue() {
        if (isEmpty()) {
            StdOut.println("Queue is empty");
            return;
        }
        Node temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    public Item peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        else {
            return front.item;
        }
    }
}
