package practice_3;

public class DoubleList {
    Node head;
    Node tail;

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
            head.previous = node;
        } else {
            tail = node;
        }
        head = node;

    }

    public void removeFirst() {
        if (head != null) {
            if (head.next != null) {
                head = head.next;
                head.previous = null;
            } else {
                head = null;
                tail = null;
            }
        }
    }


    public void addLast(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    public void removeLast() {
        if (tail != null) {
            if (tail.previous != null) {
                tail = tail.previous;
                tail.next = null;
            } else {
                tail = null;
                head = null;
            }
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        newNode.previous = node;
        node.next = newNode;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;

        }
    }

    public void delete(Node node) {
        Node next = node.next;
        Node prev = node.previous;
        if (next == null) {
            tail = prev;
            prev.next = null;
        } else {
            if (prev == null) {
                head = next;
                next.previous = null;
            } else {
                next.previous = prev;
                prev.next = next;
            }
        }
    }

    public boolean contains(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.value + " ");
            currentNode = currentNode.next;
        }
    }

public class Node {
    int value;
    Node next;
    Node previous;

    @Override
    public String toString() {
        return "Node { Value: " + value + ", Next: " + next + "}";
    }
}
}

