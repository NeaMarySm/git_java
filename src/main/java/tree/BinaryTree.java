package tree;

public class BinaryTree {
    private Node root;

    public boolean contains(int val){
        Node result = findNode(val, root);
        return result != null;
    }
    private Node findNode(int val, Node node) {
        if (node.value == val) {
            return node;
        } else {
            if (node.value > val) {
                if (node.leftChild != null) {
                    return findNode(val, node.leftChild);
                } else return null;
            } else {
                if (node.rightChild != null) {
                   return findNode(val, node.rightChild);
                } else return null;
            }
        }

    }

    private class Node {
        int value;
        private Node leftChild;
        private Node rightChild;

    }
}
