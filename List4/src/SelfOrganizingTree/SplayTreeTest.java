package SelfOrganizingTree;

import java.io.File;
import java.util.Scanner;

public class SplayTreeTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SplayTree spt = new SplayTree();
        spt.insert("c");
        spt.insert("b");
        spt.insert("g");
        spt.insert("u");
        spt.insert("a");
        spt.insert("e");
        spt.remove("a");
        spt.load(new File("D:\\IdeaProjects\\aspell_wordlist.txt"), 1);
        spt.print(spt.inorder());
        spt.load(new File("D:\\IdeaProjects\\aspell_wordlist.txt"), 2);

    }
}