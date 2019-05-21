package BinarySearchTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTree {
    static final int COUNT = 10;
  public  int comparisons=0;
    int numberOfElements, maxNumberOfElements, searchOps, insertions;
    int inorderOps, deletions;
   public int modifications = 0;
    Node root;

    public BinarySearchTree() {
        root = null;
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

    /*
    method that remove element from tree
    1) node is a leaf
    2) node has 1 child
    3) node has 2 child
     */
    void delete(String key) {
        root = deleteRec(root, key);
        deletions++;
    }

    Node deleteRec(Node root, String key) {
        if (root == null) return root;

        /* Otherwise, recur down the tree */
        comparisons++;
        if (key.compareTo(root.getKey()) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.getKey()) > 0)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else {
            comparisons++;// node with only one child or no child
            if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);
            modifications++;
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
            deletions++;
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
        insertions++;
        s = checkData(s);
        Node z = root;
        Node parent = null;
        while (z != null) {
            comparisons++;
            parent = z;
            if (s.compareTo(parent.getKey()) > 0)
                z = z.getRightNode();
            else z = z.getLeftNode();

        }
        z = new Node(s);
        z.setParent(parent);
        modifications++;

        comparisons++;
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
        searchOps++;
        return findNode(root, s) != null;
    }

    Node findNode(Node node, String key) {
        comparisons += 2;
        if (node == null || node.getKey().equals(key))
            return node;

        if (key.compareTo(node.getKey()) < 0)
            return findNode(node.getLeftNode(), key);

        return findNode(node.getRightNode(), key);
    }

    /*
    method that loads data from file
     */
    public void load(File file, int option) {
        try {
            ArrayList<String> arr = new ArrayList<>();

            FileReader FR = new FileReader(file);
            BufferedReader BR = new BufferedReader(FR);
            String line;
            comparisons = 0;
            modifications = 0;
            while (BR.readLine() != null) {

                line = BR.readLine();
                String[] stringArr = line.split(" ");

                if (option == 1) {
                    for (String s : stringArr) insert(s);
                }

                if (option == 2) {
                    for (String s : stringArr) delete(s);
                }

                if (option == 3) {
                    for (String s : stringArr) search(s);
                }

                if (option == 4 || option == 5 || option == 6) {
                    for (String s : stringArr) arr.add(s);
                }

            }
            if (option == 4)
            {
                Collections.shuffle(arr);
                for (String s : arr) insert(s);
            }
            if (option == 5)
            {
                Collections.shuffle(arr);
                for (String s : arr) delete(s);
            }
            if (option == 6)
            {
                Collections.shuffle(arr);
                for (String s : arr) search(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    method that prints elements from smallest to the biggest based on lexical
     */
    void inorder() {
        inorderRec(root);
    }
    /*
method that checks if tree is Empty
 */

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
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

    public boolean isEmpty() {
        return root == null;
    }


}
