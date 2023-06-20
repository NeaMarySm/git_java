package l_3;

public class Queue extends DoublyLinkedList{
    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
    }
    public Integer peek(){
        Integer result = null;
        if(tail != null){
            result = tail.value;
            tail = tail.previous;
            tail.next = null;
        }
        return result;
    }
}
