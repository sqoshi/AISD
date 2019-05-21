package RedBlackTree;

import static RedBlackTree.RedBlackTree.nil;

public class Node {
    String key;
    boolean color; //red -> true, black -> false
    Node left, right, parent;

    public Node(String item) {
        key = item;
        left = right = parent = nil;
    }
}