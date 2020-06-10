package tree.bst.construction.and.conversion;

import tree.avl.AVLTree;
import tree.binary.common.TreeNode;
import tree.common.Traversal;
import utils.DSUtils;

/**
 * https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
 */
public class ConvertBSTtoBalanacedBST {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getBST().getRoot();
        AVLTree avl = getAVL(root);
        avl.traverse(Traversal.LEVEL_ORDER);
    }

    public static AVLTree getAVL(TreeNode root) {

        AVLTree avl = new AVLTree();
        constructAvlTree(root, avl);
        return avl;
    }

    private static void constructAvlTree(TreeNode root, AVLTree avl) {

        if(root == null)
            return;

        constructAvlTree(root.getLeft(), avl);
        avl.insert(root.getData());
        constructAvlTree(root.getRight(), avl);
    }
}
