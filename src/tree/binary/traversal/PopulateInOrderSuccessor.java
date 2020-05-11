package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

/**
 * Logic is reverse In-Order traversal. Means [RIGHT, ROOT, LEFT]
 */
public class PopulateInOrderSuccessor {

    private static TreeNode nextPointer = null;

    public static void main(String[] args) {
        Tree tree = DSUtils.getTree();

        setInOrderSuccessor(tree.getRoot());

        inOrder(tree.getRoot());
    }

    public static void setInOrderSuccessor(TreeNode node) {

        if(node == null)
            return;

        // First traverse right
        setInOrderSuccessor(node.getRight());

        // Setting value of next In-Order successor
        node.setNext(nextPointer);

        // This one is successor for previous element
        nextPointer = node;

        setInOrderSuccessor(node.getLeft());
    }

    private static void inOrder(TreeNode root) {

        if(root == null)
            return;

        inOrder(root.getLeft());

        int data = root.getData();
        int nextSuccessor = root.getNext() != null ? root.getNext().getData() : Integer.MIN_VALUE;
        System.out.println(data + " -> " + nextSuccessor);

        inOrder(root.getRight());
    }
}
