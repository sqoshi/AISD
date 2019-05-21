package BinarySearchTree;

import java.io.File;

public class BinarySearchTreeTest {
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
        //System.out.println(BST.search("lm"));
        BST.load(new File("/home/piotr/IdeaProjects/AISD/List4/aspell_wordlist.txt"),1);
     //   BST.load(new File("/home/piotr/IdeaProjects/AISD/List4/aspell_wordlist.txt"),3);
      //  BST.load(new File("/home/piotr/IdeaProjects/AISD/List4/aspell_wordlist.txt"),5);
          BST.inorder();
        //  BST.remove("xo");
        //BST.inorder();
        //  print2D(BST.root,0);

    }
}
