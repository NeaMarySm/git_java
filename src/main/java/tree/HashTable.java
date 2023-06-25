package tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HashTable<K, V> {
    private static final int INT_BASKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Basket[] baskets;
    private int size = 0;

    public HashTable() {
        this(INT_BASKET_COUNT);
    }

    public HashTable(int size) {
        baskets = (Basket[]) Array.newInstance(Basket.class, size);
    }

    public int calculateBasketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % baskets.length;
    }

    public V get(K key) {
        int basketIndex = calculateBasketIndex(key);
        return baskets[basketIndex].get(key);
    }

    public boolean remove(K key) {
        int basketIndex = calculateBasketIndex(key);
        boolean result = baskets[basketIndex].remove(key);
        if(result) size--;
        return result;
    }

    public boolean add(K key, V value) {
        if (size >= LOAD_FACTOR * baskets.length) {
            recalculate();
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        int basketIndex = calculateBasketIndex(key);
        Basket basket = baskets[basketIndex];
        if (basket == null) {
            basket = new Basket();
            baskets[basketIndex] = basket;
        }
        boolean result = basket.add(entity);
        if (result) size++;
        return result;
    }

    public void recalculate() {
        Basket[] old = baskets;
        baskets = (Basket[]) new Object[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            Basket basket = baskets[i];
            Basket.Node node = basket.head;
            while (node != null) {
                add(node.entity.key, node.entity.value);
                node = node.next;
            }
            baskets[i] = null;
        }
    }

    private class Basket {
        Node head;

        public V get(K key) {
            Node node = head;
            while (node != null) {
                if (node.entity.key.equals(key)) {
                    return node.entity.value;
                } else {
                    node = node.next;
                }
            }
            return null;
        }

        public boolean remove(K key) {
            if (head != null) {
                Node node = head;
                if (node.entity.key.equals(key)) {
                    head = head.next;
                    return true;
                }
                while (node.next != null) {
                    if (node.next.entity.key.equals(key)) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
            }
            return false;
        }

        public boolean add(Entity entity) {
            Node node = new Node();
            node.entity = entity;
            if (head == null) {
                head = node;
            } else {
                Node currentNode = head;
                while (currentNode.next != null) {
                    if (currentNode.entity.key.equals(entity.key) || currentNode.next.entity.key.equals(entity.key)) {
                        return false;
                    }
                    currentNode = currentNode.next;
                }
                currentNode.next = node;
            }
            return true;
        }

        private class Node {
            Node next;
            Entity entity;

        }
    }

    private class Entity {
        K key;
        V value;
    }


}
