package tree.bst.test;

import tree.bst.BST;
import tree.common.Traversal;
import utils.DSUtils;

import java.util.Random;

public class BSTTest {

    public static void main(String[] args) {

        BST bst = new BST(25);
        System.out.print("Inserting data in tree : 25  |" );

        new Random()
                .ints(1,50)
                .limit(10)
                .distinct()
                .forEach(i -> {
                    System.out.print("\t" + i + "\t|");
                    bst.insert(i);
                });

        /*BST bst = DSUtils.getBST();*/

        System.out.print("\n\nIn order traversal of tree : ");
        bst.traverse(Traversal.IN_ORDER);

        System.out.print("\n\nPre order traversal of tree : ");
        bst.traverse(Traversal.PRE_ORDER);

        System.out.print("\n\nPost order traversal of tree : ");
        bst.traverse(Traversal.POST_ORDER);

        System.out.print("\n\nLevel order traversal of tree : ");
        bst.traverse(Traversal.LEVEL_ORDER);

        int s = 9;
        System.out.print("\n\nSearching : " + s + " -> " + bst.search(s));

        s = 150;
        System.out.print("\n\nDeleting : " + s);
        bst.delete(s);

        System.out.print("\n\nIn order traversal of tree after deletion of : " + s + " -> ");
        bst.traverse(Traversal.IN_ORDER);
    }
}
