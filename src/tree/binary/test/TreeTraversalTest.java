package tree.binary.test;

import tree.binary.Tree;
import utils.DSUtils;

public class TreeTraversalTest {

    public static void main(String[] args) {
        Tree tree = DSUtils.getTree();

        System.out.print("\n\nInorder Traversing : ");
        tree.inorder(tree.getRoot());

        System.out.print("\n\nPre-order Traversing : ");
        tree.preOrder(tree.getRoot());

        System.out.print("\n\nPost-order Traversing : ");
        tree.postOrder(tree.getRoot());

        System.out.print("\n\nLevel-order Traversing : ");
        tree.levelOrder(tree.getRoot());
    }
}
