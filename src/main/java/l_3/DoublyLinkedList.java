package l_3;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public void add(int value) {
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
    public void delete(Node node){
        Node next = node.next;
        Node prev = node.previous;
        if(next == null){
            tail = prev;
            prev.next = null;
        } else{
            if(prev == null){
                head = next;
                next.previous = null;
            } else {
                next.previous = prev;
                prev.next = next;
            }
        }
    }

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public void revert(){
        Node currentNode = head;
        while(currentNode!=null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if(next == null){
                head = currentNode;
            }
            if(previous == null){
                tail = currentNode;
            }
            currentNode = next;
        }
    }
    public void sort(){
        Node node = head;
        while(node.next != null){
            Node minPos = node;
            Node next = node.next;
            while(next != null){
                if(next.value < minPos.value){
                    minPos = next;
                }
                next = next.next;
            }
            if(minPos != node){
                swap(node, minPos);
                if(minPos.previous == null){
                    head = minPos;
                }
                if(node.next == null){
                    tail = node;
                }
                node = minPos.next;
            } else {
                node = node.next;
            }

        }
    }
    private void swap(Node first, Node second){
        Node tmp = first.previous;
        first.previous = second;
        second.previous = tmp;
        tmp = second.next;
        second.next = first;
        first.next = tmp;
        if(first.next != null){
            first.next.previous = first;
        }
        if(first.previous != null){
            first.previous.next = first;
        }
        if(second.next != null){
            second.next.previous = second;
        }
        if(second.previous != null){
            second.previous.next = second;
        }
    }
    public class Node {
        int value;
        Node next;
        Node previous;
    }
}
