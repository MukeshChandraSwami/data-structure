package tree.binary.test;

import tree.binary.Tree;

import java.util.Random;

public class TreeTest {

    public static void main(String[] args) {

        Tree tree = new Tree(20);
        System.out.print("Inserting data");
        new Random().ints(0,50)
                .limit(9)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    tree.insert(data);
                });

        System.out.print("\n\nTraversing : ");
        tree.inorder(tree.getRoot());
    }
}
