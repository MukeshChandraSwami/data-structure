package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

/**
 * Step 1 : Traverse left boundary.
 * Step 2 : Traverse leaves of the tree.
 * Step 3 : traverse right boundary.
 */
public class BoundaryTraversal {

    public static void main(String[] args) {

        Tree tree = DSUtils.getTree();

        printLeftBoundary(tree.getRoot());

        printLeaves(tree.getRoot());

        printRightBoundary(tree.getRoot().getRight());
    }

    public static void printLeftBoundary(TreeNode node) {

        if(node.getLeft() == null)
            return;
        System.out.print("\t" + node.getData() + "\t|");
        printLeftBoundary(node.getLeft());
    }

    public static void printLeaves(TreeNode node) {

        if(node == null)
            return;
        printLeaves(node.getLeft());

        if(node.getLeft() == null && node.getRight() == null)
            System.out.print("\t" + node.getData() + "\t|");

        printLeaves(node.getRight());
    }

    public static void printRightBoundary(TreeNode node) {

        if(node == null)
            return;

        printRightBoundary(node.getRight());
        System.out.print("\t" + node.getData() + "\t|");
    }
}
