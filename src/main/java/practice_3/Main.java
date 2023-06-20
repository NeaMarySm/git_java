package practice_3;

public class Main {
    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
//        linkedList.addFirst(1);
//        linkedList.addFirst(2);
//        linkedList.addFirst(3);
//        linkedList.addLast(5);
//        linkedList.addLast(6);
//        linkedList.addLast(8);
//        linkedList.printList();
//        linkedList.removeFirst();
//        linkedList.removeLast();
//        System.out.println(linkedList.head);
//        System.out.println(linkedList.contains(2));
//        System.out.println(linkedList.contains(8));

        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(1);
        doubleList.addFirst(2);
        doubleList.addFirst(3);
        doubleList.addLast(5);
        doubleList.addLast(6);
        doubleList.addLast(8);
        doubleList.printList();
        doubleList.removeFirst();
        doubleList.printList();
        doubleList.removeLast();
        System.out.println("*".repeat(10));
        System.out.println(doubleList.head);
        System.out.println(doubleList.contains(2));
        System.out.println(doubleList.contains(8));
    }
}
