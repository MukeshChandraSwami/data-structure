package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class CheckIfBST {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTree().getRoot();
        boolean status = checkRecursively(root);
        System.out.print("Is BST : " + status);
    }

    private static boolean checkRecursively(TreeNode root) {

        if(root == null || (root.getLeft() == null && root.getRight() == null))
            return true;

        if(root.getLeft() != null && root.getLeft().getData() >= root.getData())
            return false;

        if(root.getRight() != null && root.getRight().getData() <= root.getData())
            return false;


        return checkRecursively(root.getLeft())
                && checkRecursively(root.getRight());
    }
}
