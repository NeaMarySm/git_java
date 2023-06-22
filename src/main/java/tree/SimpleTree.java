package tree;

import java.util.ArrayList;
import java.util.List;

public class SimpleTree {
    private Node root;

    public boolean contains(int val) {
        if (root != null) {
            return contains(val, root);
        } else return false;
    }

    private boolean contains(int val, Node node) {
        if (node.value == val) {
            return true;
        } else {
            for (Node child : node.children) {
                if (contains(val, child)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<Integer> values() {
        List<Integer> result = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Node> children = new ArrayList<>();
            for (Node node : nodes) {
                result.add(node.value);
                children.addAll(node.children);
            }
            nodes = children;
        }
        return result;
    }


    private class Node {
        private int value;
        private List<Node> children;

    }

}
