package BinarySearchTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTree {
    static final int COUNT = 10;
    int comparisions = 0;
    int changes = 0;
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        BST.insert("xo");
        BST.insert("m");
        BST.insert("s");
        BST.insert("c");
        BST.insert("xd");
        BST.insert("f");
        BST.insert("x");
        BST.insert("j");
        BST.insert("k");
        BST.insert("a");
        BST.insert("A");
        BST.insert("n");
        BST.insert("d");
        BST.insert("u");
        BST.insert("l");
        BST.insert("z");
        BST.insert("!a");
        System.out.println(BST.search("lm"));
        //   BST.load("aspell_wordlist");
      //  BST.inorder();
      //  BST.remove("xo");
      //  BST.inorder();
        print2D(BST.root,0);

    }



    /*
    method that remove element from tree
    1) node is a leaf
    2) node has 1 child
    3) node has 2 child
     */
    void remove(String key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, String key) {
        if (root == null) return root;

        /* Otherwise, recur down the tree */
        if (key.compareTo(root.getKey()) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.getKey()) > 0)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    String minValue(Node root) {
        String minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    /*
    method that insert element to tree
     */
    public void insert(String s) {
        s = checkData(s);
        Node z = root;
        Node parent = null;
        while (z != null) {
            parent = z;
            if (s.compareTo(parent.getKey()) > 0)
                z = z.getRightNode();
            else z = z.getLeftNode();

        }
        z = new Node(s);
        z.setParent(parent);

        if (parent == null) {
            root = z;
        } else if (s.compareTo(parent.getKey()) > 0)
            parent.setRightNode(z);
        else
            parent.setLeftNode(z);

    }

    /*
    function that search if and where elements is
     */
    boolean search(String s) {
        return findNode(root, s) != null;
    }

    Node findNode(Node node, String key) {
        if (node == null || node.getKey().equals(key))
            return node;

        if (key.compareTo(node.getKey()) < 0)
            return findNode(node.getLeftNode(), key);

        return findNode(node.getRightNode(), key);
    }

    /*
    method that loads data from file
     */
    void load(String file) {
        String fileName = "/home/piotr/IdeaProjects/AISD/List4/" + file + ".txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File: " + file + "doesn't exists");
        }
        assert scanner != null;
        scanner.useDelimiter("\\s+");
        while (scanner.hasNext()) {
            String temp = scanner.next();
            //  System.out.println(temp);
            insert(temp);
        }
        scanner.close();
    }

    /*
    method that prints elements from smallest to the biggest based on lexical
     */
    void inorder() {
        inorderRec(root);
        System.out.print("- BigGest ");
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key);
            System.out.print(" < ");
            inorderRec(root.right);
        }

    }

    /*
    method that checks if char at 0 or length-1 is not from a-z class
     */
    String checkData(String data) {
        String temp = data;
        int n = data.length();
        if (!Character.isLetter(data.charAt(0))) {
            temp = data.substring(1);
            return temp;
        } else if (!Character.isLetter(data.charAt(n - 1))) {
            temp = data.substring(0, n - 1);
            return temp;
        }
        return temp;
    }
    /*
method that checks if tree is Empty
 */

    public boolean isEmpty() {
        return root == null;
    }

    static void print2DUtil(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.key + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Node root, int i) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }


}
