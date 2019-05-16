package SelfOrganizingTree;

class SplayNode {
    SplayNode left;
    SplayNode right;
    SplayNode parent;
    String key;

    public SplayNode() {
        this(null, null, null, null);
    }

    public SplayNode(String ele) {
        this(ele, null, null, null);
    }

    public SplayNode(String ele, SplayNode left, SplayNode right, SplayNode parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.key = ele;
    }

    String getKey() {
        return key;
    }

    void setKey(String key) {
        this.key = key;
    }

    SplayNode getLeft() {
        return left;
    }

    void setLeft(SplayNode node) {
        left = node;
    }

    SplayNode getRight() {
        return right;
    }

    void setRight(SplayNode node) {
        right = node;
    }

    SplayNode getParent() {
        return parent;
    }

    void setParent(SplayNode node) {
        parent = node;
    }
}
