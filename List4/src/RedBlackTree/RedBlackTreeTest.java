package RedBlackTree;

import java.io.File;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert("a");
        rbt.insert("xd");
        rbt.insert("pox");
        rbt.insert("xo");
        rbt.load(new File("/home/piotr/IdeaProjects/AISD/List4/aspell_wordlist.txt"),1);
        rbt.inorder();
    }
}
