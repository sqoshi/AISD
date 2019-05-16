package SelfOrganizingTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class SplayTree
{
    private SplayNode root;
    private int count = 0;
    int comparison = 0;
    int changes=0;


    public SplayTree()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }


    public void insert(String ele)
    {
        SplayNode z = root;
        SplayNode p = null;
        while (z != null)
        {
            p = z;
            if (ele.compareTo(p.getKey())>0) z = z.getRight();
            else z = z.getLeft();
            comparison++;

        }
        z = new SplayNode();
        z.setKey(ele);
        z.setParent(p);
        changes++;
        if (p == null)
            root = z;
        else if (ele.compareTo(p.getKey())>0 )
            p.setRight(z);
        else
            p.setLeft(z);
        changes++;
        Splay(z);
        count++;
    }

    public void makeLeftChildParent(SplayNode c, SplayNode p)
    {
        if ((c == null) || (p == null) || (p.getLeft() != c) || (c.getParent() != p))
            throw new RuntimeException("WRONG");

        if (p.getParent() != null)
        {
            if (p == p.getParent().getLeft())
                p.getParent().setLeft(c);
            else
                p.getParent().setRight(c);
            changes++;
            comparison++;
        }
        if (c.getRight() != null) {
            c.getRight().setParent(p);
            changes++;
        }

        c.setParent(p.getParent());
        p.setParent(c);
        p.setLeft(c.getRight());
        c.setRight(p);
        comparison++;
        changes+=2;

    }

    public void makeRightChildParent(SplayNode c, SplayNode p)
    {
        if ((c == null) || (p == null) || (p.getRight() != c) || (c.getParent() != p))
            throw new RuntimeException("WRONG");
        if (p.getParent() != null)
        {
            if (p == p.getParent().getLeft())
                p.getParent().setLeft(c);
            else
                p.getParent().setRight(c);
            changes++;
            comparison++;
        }
        if (c.getLeft() != null) {
            c.getLeft().setParent(p);
            changes++;
        }
        c.setParent(p.getParent());
        p.setParent(c);
        p.setRight(c.getLeft());
        c.setLeft(p);
        changes+=2;
        comparison++;
    }


    private void Splay(SplayNode x)
    {
        while (x.getParent() != null)
        {
            SplayNode Parent = x.getParent();
            SplayNode GrandParent = Parent.getParent();
            if (GrandParent == null)
            {
                if (x == Parent.getLeft())
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);
                comparison++;
            }
            else
            {
                if (x == Parent.getLeft())
                {
                    if (Parent == GrandParent.getLeft())
                    {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    }
                    else
                    {
                        makeLeftChildParent(x, x.getParent());
                        makeRightChildParent(x, x.getParent());
                    }
                    comparison++;
                }
                else
                {
                    if (Parent == GrandParent.getLeft())
                    {
                        makeRightChildParent(x, x.getParent());
                        makeLeftChildParent(x, x.getParent());
                    }
                    else
                    {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                    comparison++;
                }
                comparison++;
            }
            comparison++;
        }
        root = x;
    }


    void remove(String ele)
    {
        SplayNode node = findNode(ele);
        remove(node);
    }

    private void remove(SplayNode node)
    {
        if (node == null)
            return;

        Splay(node);
        if( (node.getLeft() != null) && (node.getRight() !=null))
        {
            SplayNode min = node.getLeft();
            while(min.getRight()!=null)
                min = min.getRight();

            min.setRight(node.getRight());
            node.getRight().setParent(min);
            node.getLeft().setParent(null);
            root = node.getLeft();
            changes+=3;
        }
        else if (node.getRight()!= null)
        {
            node.getRight().setParent(null);
            root = node.getRight();
            changes++;
        }
        else if( node.getLeft() !=null)
        {
            node.getLeft().setParent(null);
            root = node.getLeft();
            changes++;
        }
        else
        {
            root = null;
        }
        node.setParent(null);
        node.setLeft(null);
        node.setRight(null);
        comparison++;
        changes++;
        node = null;
        count--;
    }
    ArrayList<SplayNode> inorder(){
        if(root==null){
            System.out.println("EMPTY TREEE");
            return null;
        }
        ArrayList<SplayNode> arr =new ArrayList<>();
        SplayNode max = root;
        SplayNode node = root;
        while(max.getRight()!=null){
            max = max.getRight();
        }
        while(node.getLeft()!=null){
            node = node.getLeft();
        }
        arr.add(node);
        while(node!=max){
            node = findSuccessor2(node);
            arr.add(node);
        }
        return arr;
    }
    private SplayNode findSuccessor2(SplayNode node){
        if(node.getRight() != null){
            node = node.getRight();
            while(node.getLeft()!= null){
                node=node.getLeft();
            }
            return node;
        }
        SplayNode parent = node.getParent();
        while(parent!=null && node==parent.getRight()){
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }
    void print(ArrayList<SplayNode> arr){
        if(arr==null)return;
        for(SplayNode n:arr){
            System.out.println(n.getKey());
        }
    }
    void load(File file,int option){
        try {
            ArrayList<String> arr = new ArrayList<>();

            FileReader FR = new FileReader(file);
            BufferedReader BR = new BufferedReader(FR);
            String line;
            comparison=0;
            changes=0;
            while(BR.readLine()!=null){
                line = BR.readLine();
                String[] stringArr = line.split(" ");
                if(option==1) {
                    for (String s : stringArr) insert(s);
                }
                if(option==2){
                    for(String s:stringArr)remove(s);
                }
                if(option==3){
                    for(String s:stringArr)search(s);
                }
                if(option==4 || option==5 || option==6){
                    for(String s:stringArr)arr.add(s);
                }
            }
            if(option==4){
                Collections.shuffle(arr);
                for(String s:arr)insert(s);
            }
            if(option==5){
                Collections.shuffle(arr);
                for(String s:arr)remove(s);
            }
            if(option==6){
                Collections.shuffle(arr);
                for(String s:arr)search(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean search(String val)
    {
        return findNode(val) != null;
    }

    private SplayNode findNode(String ele)
    {
        SplayNode PrevNode = null;
        SplayNode z = root;
        while (z != null)
        {
            PrevNode = z;
            if (ele.compareTo(z.getKey())>0)
                z = z.getRight();
            else if (ele.compareTo(z.getKey())<0)
                z = z.getLeft();
            else if(ele.compareTo(z.getKey())==0) {
                Splay(z);
                return z;
            }
            comparison++;

        }
        if(PrevNode != null)
        {
            Splay(PrevNode);
            return null;
        }
        return null;
    }

}