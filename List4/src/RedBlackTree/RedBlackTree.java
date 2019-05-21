package RedBlackTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class RedBlackTree {

    public int comparisons;
    int modifications = 0;
    int numberOfElements, maxNumberOfElements, searchOps, insertions;
    int inorderOps, deletions;
    public static Node nil;
    private Node root;

    public RedBlackTree() {
        nil = new Node("");
        nil.color = false;
        root = nil;
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

    //  @Override
    public void inorder() {
        inorderOp(root);
        System.out.println();


        inorderOps++;
    }

    private void inorderOp(Node root) {
        if (root != nil) {
            inorderOp(root.left);
            System.out.print(root.key + " ");
            inorderOp(root.right);
        }
    }

    // @Override
    public void search(String key) {
        System.out.println(searchOp(this.root, key) != nil);
         searchOp(this.root, key);
        searchOps++;
    }

    // @Override
    public void insert(String key) {
        numberOfElements++;
        if (numberOfElements > maxNumberOfElements) maxNumberOfElements = numberOfElements;
        insertions++;
//false black;
        //insert

        key = checkData(key);

        Node z = new Node(key);
        Node y = nil;
        modifications++;
        Node x = root;

        while (x != nil) {
            y = x;

            comparisons++;
            if (z.key.compareTo(x.key) < 0) {
                x = x.left;
            } else
                x = x.right;
        }

        z.parent = y;
        if (y == nil) {
            this.root = z;
        } else {
            comparisons++;
            if (z.key.compareTo(y.key) < 0) {
                y.left = z;
            } else {
                y.right = z;
            }
        }
        modifications++;

        //RB insert
        z.color = true;
        while (z != root && z.parent.color) {
            comparisons += 2;

            comparisons++;
            if (z.parent == z.parent.parent.left) {
                y = z.parent.parent.right;

                if (y.color) {
                    comparisons++;
                    modifications += 3;

                    z.parent.color = false;
                    y.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        comparisons += 2;

                        z = z.parent;
                        rotateLeft(z);
                    }
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    rotateRight(z.parent.parent);
                }
            } else {
                y = z.parent.parent.left;

                if (y.color) {
                    modifications += 3;
                    comparisons++;

                    z.parent.color = false;
                    y.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {
                    if (z.parent.left == z) {
                        comparisons += 2;

                        z = z.parent;
                        rotateRight(z);
                    }
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    rotateLeft(z.parent.parent);
                    modifications++;
                }
            }
        }
        comparisons += 2;

        root.color = false;
    }

    //@Override
    public void delete(String key) {
        deletions++;

        Node z = searchOp(root, key);
        if (z == nil) {
            return;
        }

        numberOfElements--;

        Node y;
        Node x;

        if (z.left == nil || z.right == nil) {
            y = z;
        } else {
            y = treeSuccessor(z);
        }

        if (y.left != nil) {
            x = y.left;
        } else {
            x = y.right;
        }

        modifications++;
        x.parent = y.parent;

        if (y.parent == nil) {
            root = x;
        } else {
            if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
            comparisons++;
        }

        if (y != z) {
            modifications++;
            z.key = y.key;
        }

        comparisons++;
        if (!y.color) {
            deleteFixup(x);
        }
    }

    private void deleteFixup(Node x) {
        Node w;


        while (x != root && !x.color) {
            comparisons += 2;

            comparisons++;
            if (x == x.parent.left) {
                w = x.parent.right;

                comparisons++;
                if (w.color) {

                    w.color = false;
                    x.parent.color = true;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }

                comparisons += 2;
                if (!w.left.color && !w.right.color) {
                    modifications++;

                    w.color = true;
                    x = x.parent;
                } else {
                    comparisons++;
                    if (!w.right.color) {

                        w.left.color = false;
                        w.color = true;
                        rotateRight(w);
                        w = x.parent.right;
                    }

                    w.color = x.parent.color;
                    x.parent.color = false;
                    w.right.color = false;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                w = x.parent.left;

                comparisons++;
                if (w.color) {

                    w.color = false;
                    x.parent.color = true;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }

                comparisons += 2;
                if (!w.right.color && !w.left.color) {
                    modifications++;

                    w.color = true;
                    x = x.parent;
                } else {
                    comparisons++;
                    if (!w.left.color) {

                        w.right.color = false;
                        w.color = true;
                        rotateLeft(w);
                        w = x.parent.left;
                    }

                    w.color = x.parent.color;
                    x.parent.color = false;
                    w.left.color = false;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        comparisons += 2;

        x.color = false;
    }

    private Node treeSuccessor(Node x) {

        if (x.right != nil) return treeMinimum(x.right);

        Node y = x.parent;
        while (y != nil && x == y.right) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    private Node treeMinimum(Node x) {
        while (x.left != nil) {
            comparisons++;
            x = x.left;
        }
        comparisons++;

        return x;
    }

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != nil) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == nil) {
            root = y;
        } else {
            comparisons++;
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        modifications += 2;
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;

        if (y.right != nil) {
            y.right.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == nil) {
            this.root = y;
        } else {
            comparisons++;
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        modifications += 2;
        y.right = x;
        x.parent = y;
    }

    private Node searchOp(Node root, String key) {
        if (root == nil) return nil;

        int cmp = root.key.compareTo(key);

        comparisons++;
        if (cmp == 0) return root;

        if (cmp > 0)
            return searchOp(root.left, key);

        return searchOp(root.right, key);
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
                    for (String s : stringArr) delete(s);
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
                for (String s : arr) delete(s);
            }
            if (option == 6) {
                Collections.shuffle(arr);
                for (String s : arr) search(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


