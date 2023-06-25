package tree;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.add("first", 1);
        hashTable.add("second", 2);
        hashTable.add("third", 3);
        System.out.println("hashTable.get(\"first\") = " + hashTable.get("first"));
    }
}
