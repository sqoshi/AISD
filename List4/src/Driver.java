import BinarySearchTree.BinarySearchTree;
import RedBlackTree.RedBlackTree;
import SelfOrganizingTree.SplayTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        RedBlackTree rbt = new RedBlackTree();
        //SplayTree avlt = new SplayTree();
        bst.load(new File("/home/piotr/IdeaProjects/AISD/List4/aspell_wordlist.txt"), 4);
        //save();
        rbt.load(new File("/home/piotr/IdeaProjects/AISD/List4/aspell_wordlist.txt"), 4);
        rbt.insert("a");
        rbt.search("asdasdkkkko");
        //avlt.load(new File("/home/piotr/IdeaProjects/AISD/List4/aspell_wordlist.txt"), 4);
    }

    static void save() {
        SplayTree avlt = new SplayTree();
        RedBlackTree rbt = new RedBlackTree();
        // FileWriter fw = new FileWriter("pomiar.txt");
        System.out.println(rbt.comparisons + "  " + avlt.modifications);
    }


}
