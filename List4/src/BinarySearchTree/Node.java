package BinarySearchTree;

public class Node {

    public String key;
    public Node left;
    public Node right;
    public Node parent;

    Node(String key) {
        this.key = key;
        left = null;
        right = null;
        parent = null;

    }

    Node getParent() {
        return parent;
    }

    void setParent(Node node) {
        parent = node;
    }

    Node getLeftNode() {
        return left;
    }

    void setLeftNode(Node node) {
        left = node;
    }

    Node getRightNode() {
        return right;
    }

    void setRightNode(Node node) {
        right = node;
    }

    String getKey() {
        return key;
    }

    void setKey(String key) {
        this.key = key;
    }
}