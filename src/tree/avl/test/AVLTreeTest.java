package tree.avl.test;

import tree.avl.AVLTree;
import tree.common.Traversal;

import java.util.stream.Stream;

public class AVLTreeTest {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree(14);
        Stream.of(17,11,7,53,4,13,12,8,60,19,16,20)
                .forEach(i -> {
                    tree.insert(i);
                    System.out.print("\n\nTraversing after insertion of -> " + i + " : ");
                    tree.traverse(Traversal.LEVEL_ORDER);
                });

        System.out.print("\n\nFinal traversing : ");
        tree.traverse(Traversal.LEVEL_ORDER);
    }
}
