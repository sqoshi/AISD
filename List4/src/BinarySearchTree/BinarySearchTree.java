package BinarySearchTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTree {
    int comparisions = 0;
    int changes = 0;

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
     // BST.insert("xo");
     // BST.insert("m");
     // BST.insert("s");
     // BST.insert("c");
     // BST.insert("xd");
     // BST.insert("f");
     // BST.insert("x");
     // BST.insert("j");
     // BST.insert("k");
     // BST.insert("a");
     // BST.insert("A");
     // BST.insert("n");
     // BST.insert("d");
     // BST.insert("u");
     // BST.insert("l");
     // BST.insert("z");
     // BST.insert("!a");
     // BST.print();
     // System.out.println(BST.search("lm"));
        BST.load("aspell_wordlist");
        BST.print();
       // System.out.println("ja.v_,a".replaceAll("[^a-zA-Z]", ""));

    }

    void load(String file) {
        String fileName = "/home/piotr/IdeaProjects/AISD/List4/" + file + ".txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File: " + file + "doesn't exists");
        }
        scanner.useDelimiter("\\s+");
        while (scanner.hasNext()) {
            String temp = scanner.next();
            System.out.println(temp);
            insert(temp);
        }
        scanner.close();
    }

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


    public void insert(String s) {
        checkData(s);
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


    boolean search(String s) {
        return findNode(root, s) != null;
    }

    public Node findNode(Node node, String key) {
        if (node == null || node.getKey().equals(key))
            return node;

        if (key.compareTo(node.getKey()) < 0)
            return findNode(node.getLeftNode(), key);

        return findNode(node.getRightNode(), key);
    }


    public boolean isEmpty() {
        return root == null;
    }


    /*
    Function to print travesal from left to right
     */
    void print() {
        inorderRec(root);
        System.out.print("- BigGest ");
        System.out.println();
    }

    /*
    Recursive Function to print travesal from left to right
    */
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key);
            System.out.print(" < ");
            inorderRec(root.right);
        }

    }
}
