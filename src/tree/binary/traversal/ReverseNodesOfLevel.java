package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class ReverseNodesOfLevel {

    public static void main(String[] args) {

        Tree tree = DSUtils.getPerfectBinaryTree3Levels();
        System.out.print("Reverse Siblings of all levels : ");
        reverseSiblingsOfAllLevels(tree.getRoot().getLeft(),tree.getRoot().getRight());
        tree.inorder(tree.getRoot());

        System.out.print("\n\nReverse Siblings of alternate levels : ");
        tree = DSUtils.getPerfectBinaryTree3Levels();
        reverseSiblingsOnAlternateLevel(tree.getRoot().getLeft(), tree.getRoot().getRight(), 0);
        tree.inorder(tree.getRoot());

        System.out.print("\n\nReverse nodes of levels (Mirror image of tree): ");
        tree = DSUtils.getPerfectBinaryTree3Levels();
        reverseNodesOfAllLevels(tree.getRoot().getLeft(), tree.getRoot().getRight());
        tree.inorder(tree.getRoot());

        System.out.print("\n\nReverse nodes of alternate levels : ");
        tree = DSUtils.getPerfectBinaryTree3Levels();
        reverseNodesOfAlternateLevels(tree.getRoot().getLeft(), tree.getRoot().getRight(), 0);
        tree.inorder(tree.getRoot());

    }

    /**
     * @param left
     * @param right
     *
     * Reverse sibling on their place.
     */
    public static void reverseSiblingsOfAllLevels(TreeNode left, TreeNode right) {

        if(left == null || right == null)
            return;

        int temp = left.getData();
        left.setData(right.getData());
        right.setData(temp);

        reverseSiblingsOfAllLevels(left.getLeft(), left.getRight());
        reverseSiblingsOfAllLevels(right.getLeft(), right.getRight());
    }

    /**
     * @param left
     * @param right
     * @param level
     *
     * Reverse siblings on alternate levels.
     */
    public static void reverseSiblingsOnAlternateLevel(TreeNode left, TreeNode right, int level) {

        if(left == null || right == null)
            return;

        if(level % 2 == 0) {
            int temp = left.getData();
            left.setData(right.getData());
            right.setData(temp);
        }
        reverseSiblingsOnAlternateLevel(left.getLeft(), left.getRight(), level+1);
        reverseSiblingsOnAlternateLevel(right.getLeft(), right.getRight(), level+1);
    }

    /**
     * @param left
     * @param right
     *
     * This will create a mirror image of tree.
     * Left sub tree will become right sub tree.
     */
    public static void reverseNodesOfAllLevels(TreeNode left, TreeNode right) {

        if(left == null || right == null)
            return;

        int temp = left.getData();
        left.setData(right.getData());
        right.setData(temp);

        reverseNodesOfAllLevels(left.getLeft(),right.getRight());
        reverseNodesOfAllLevels(left.getRight(),right.getLeft());
    }

    /**
     * @param left
     * @param right
     * @param level
     *
     * Reverse nodes of alternate levels.
     */
    public static void reverseNodesOfAlternateLevels(TreeNode left, TreeNode right, int level) {

        if(left == null || right == null)
            return;

        if(level % 2 == 0) {
            int temp = left.getData();
            left.setData(right.getData());
            right.setData(temp);
        }

        reverseNodesOfAlternateLevels(left.getLeft(),right.getRight(), level+1);
        reverseNodesOfAlternateLevels(left.getRight(),right.getLeft(), level+1);
    }
}
