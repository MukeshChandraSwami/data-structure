package tree.binary.traversal;

import tree.binary.Tree;
import utils.DSUtils;

public class MorrisTraversal {

    public static void main(String[] args) {

        System.out.print("Inorder Traversing : ");
        morrisInOrderTraversal(DSUtils.getTree());

        System.out.print("\n\nPre-order Traversing : ");
        morrisPreOrderTraversal(DSUtils.getTree());

        System.out.print("\n\nPost-order Traversing : ");
        morrisPostOrderTraversal(DSUtils.getTree());

    }

    public static void morrisPreOrderTraversal(Tree tree) {
        TraverseWithoutRecursion.preOrderTraversal2(tree.getRoot());
    }

    public static void morrisInOrderTraversal(Tree tree) {
        TraverseWithoutRecursion.inOrderTraversal3(tree.getRoot());
    }

    public static void morrisPostOrderTraversal(Tree tree) {
        TraverseWithoutRecursion.postOrderTraversal2(tree.getRoot());
    }
}
