package tree.binary.traversal;

import tree.binary.Tree;
import utils.DSUtils;

public class MorrisTraversal {

    public static void main(String[] args) {

        morrisPreOrderTraversal(DSUtils.getTree());
    }

    public static void morrisPreOrderTraversal(Tree tree) {

    }

    public static void morrisInOrderTraversal(Tree tree) {
        TraverseWithoutRecursion.inOrderTraversal3(tree.getRoot());
    }
}
