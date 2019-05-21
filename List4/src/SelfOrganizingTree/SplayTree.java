package SelfOrganizingTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SplayTree {
    static int COUNT = 2;
    public SplayNode root;
    public int modifications = 0;
    int comparisons = 0;
    int numberOfElements, maxNumberOfElements, searchOps, insertions;
    int inorderOps, deletions;


    public SplayTree() {
        root = null;
    }

    static void print2DUtil(SplayNode root, int space) {
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
    static void print2D(SplayNode root, int i) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(String ele) {
        insertions++;
        ele = checkData(ele);
        SplayNode z = root;
        SplayNode p = null;
        while (z != null) {
            p = z;
            if (ele.compareTo(p.getKey()) > 0)
                z = z.getRight();
            else z = z.getLeft();
            comparisons++;

        }
        z = new SplayNode();
        z.setKey(ele);
        z.setParent(p);
        modifications++;
        if (p == null)
            root = z;
        else if (ele.compareTo(p.getKey()) > 0)
            p.setRight(z);
        else
            p.setLeft(z);
        modifications++;
        Splay(z);
        //count++;
    }

    private void Splay(SplayNode x) {

        while (x.getParent() != null) {
            SplayNode Parent = x.getParent();
            SplayNode GrandParent = Parent.getParent();
            if (GrandParent == null) {
                if (x == Parent.getLeft())
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);
                comparisons++;
            } else {
                if (x == Parent.getLeft()) {
                    if (Parent == GrandParent.getLeft()) {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    } else {
                        makeLeftChildParent(x, x.getParent());
                        makeRightChildParent(x, x.getParent());
                    }
                    comparisons++;
                } else {
                    if (Parent == GrandParent.getLeft()) {
                        makeRightChildParent(x, x.getParent());
                        makeLeftChildParent(x, x.getParent());
                    } else {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                    comparisons++;
                }
                comparisons++;
            }
            comparisons++;
        }
        root = x;
    }

    public void makeLeftChildParent(SplayNode c, SplayNode p) {
        if ((c == null) || (p == null) || (p.getLeft() != c) || (c.getParent() != p))
            throw new RuntimeException("WRONG");

        if (p.getParent() != null) {
            if (p.equals(p.getParent().getLeft()))
                p.getParent().setLeft(c);
            else
                p.getParent().setRight(c);
            modifications++;
            comparisons++;
        }
        if (c.getRight() != null) {
            c.getRight().setParent(p);
            modifications++;
        }

        c.setParent(p.getParent());
        p.setParent(c);
        p.setLeft(c.getRight());
        c.setRight(p);
        comparisons++;
        modifications += 2;

    }

    public void makeRightChildParent(SplayNode c, SplayNode p) {
        if ((c == null) || (p == null) || (p.getRight() != c) || (c.getParent() != p))
            throw new RuntimeException("WRONG");
        if (p.getParent() != null) {
            if (p == p.getParent().getLeft())
                p.getParent().setLeft(c);
            else
                p.getParent().setRight(c);
            modifications++;
            comparisons++;
        }
        if (c.getLeft() != null) {
            c.getLeft().setParent(p);
            modifications++;
        }
        c.setParent(p.getParent());
        p.setParent(c);
        p.setRight(c.getLeft());
        c.setLeft(p);
        modifications += 2;
        comparisons++;
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


    void remove(String ele) {
        SplayNode node = findNode(ele);
        remove(node);
    }

    private void remove(SplayNode node) {
        if (node == null)
            return;

        Splay(node);
        if ((node.getLeft() != null) && (node.getRight() != null)) {
            SplayNode min = node.getLeft();
            while (min.getRight() != null)
                min = min.getRight();

            min.setRight(node.getRight());
            node.getRight().setParent(min);
            node.getLeft().setParent(null);
            root = node.getLeft();
            modifications += 3;
        } else if (node.getRight() != null) {
            node.getRight().setParent(null);
            root = node.getRight();
            modifications++;
        } else if (node.getLeft() != null) {
            node.getLeft().setParent(null);
            root = node.getLeft();
            modifications++;
        } else {
            root = null;
        }
        node.setParent(null);
        node.setLeft(null);
        node.setRight(null);
        comparisons++;
        modifications++;
        node = null;
        // count--;
    }


    ArrayList<SplayNode> inorder() {
        if (root == null) {
            System.out.println("EMPTY TREEE");
            return null;
        }
        ArrayList<SplayNode> arr = new ArrayList<>();
        SplayNode max = root;
        SplayNode node = root;
        while (max.getRight() != null) {
            max = max.getRight();
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        arr.add(node);
        while (node != max) {
            node = findSuccessor2(node);
            arr.add(node);
        }
        return arr;
    }


    private SplayNode findSuccessor2(SplayNode node) {
        if (node.getRight() != null) {
            node = node.getRight();
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
            return node;
        }
        SplayNode parent = node.getParent();
        while (parent != null && node == parent.getRight()) {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    void print(ArrayList<SplayNode> arr) {
        if (arr == null) return;
        for (SplayNode n : arr) {
            System.out.println(n.getKey());
        }
    }

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
                    for (String s : stringArr) remove(s);
                }
                if (option == 3) {
                    for (String s : stringArr) search(s);
                }
                if (option == 4 || option == 5 || option == 6) {
                    for (String s : stringArr) arr.add(s);
                }
            }
            if (option == 4) {
                Collections.shuffle(arr);
                for (String s : arr) insert(s);
            }
            if (option == 5) {
                Collections.shuffle(arr);
                for (String s : arr) remove(s);
            }
            if (option == 6) {
                Collections.shuffle(arr);
                for (String s : arr) search(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean search(String val) {
        return findNode(val) != null;
    }

    private SplayNode findNode(String ele) {
        SplayNode PrevNode = null;
        SplayNode z = root;
        while (z != null) {
            PrevNode = z;
            if (ele.compareTo(z.getKey()) > 0)
                z = z.getRight();
            else if (ele.compareTo(z.getKey()) < 0)
                z = z.getLeft();
            else if (ele.compareTo(z.getKey()) == 0) {
                Splay(z);
                return z;
            }
            comparisons++;

        }
        if (PrevNode != null) {
            Splay(PrevNode);
            return null;
        }
        return null;
    }

}