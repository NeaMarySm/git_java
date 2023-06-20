package practice_3;


public class LinkedList {
    Node head;

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            node.next = null;

        } else {
            node.next = head;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
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

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }

    public void removeLast() {
        if (head != null) {
            Node currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.next.next == null) {
                    currentNode.next = null;
                } else {
                    currentNode = currentNode.next;
                }
            }
        }
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

        @Override
        public String toString() {
            return "Node { Value: " + value + ", Next: " + next + "}";
        }
    }
}
