package l_3;

public class Stack extends SinglyLinkedList{
    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
    }
    public Integer pop(){
        Integer result = null;
        if(head != null){
            result = head.value;
            head = head.next;
        }
        return result;
    }
}
