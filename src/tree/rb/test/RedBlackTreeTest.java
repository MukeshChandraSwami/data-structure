package tree.rb.test;

import tree.common.Traversal;
import tree.rb.RedBlackTree;

import java.util.Random;
import java.util.stream.Stream;

public class RedBlackTreeTest {

    public static void main(String[] args) {

        RedBlackTree rb = new RedBlackTree();
        /*new Random()
                .ints(1, 100)
                .limit(10)
                .distinct()
                .forEach(rb::insert);*/

        Stream.of(22,30,88,6,89,94,52)
                .forEach(rb::insert);
        System.out.print("In-Order : ");
        rb.traverse(Traversal.IN_ORDER);
        System.out.print("\n\nPre-Order : ");
        rb.traverse(Traversal.PRE_ORDER);

    }
}
