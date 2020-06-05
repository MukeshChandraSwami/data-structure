package tree.binary;

import tree.binary.common.TreeNode;
import utils.DSUtils;

/**
 * https://www.geeksforgeeks.org/continuous-tree/
 */
public class ContinuousBT {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getContinuousTree().getRoot();
        boolean status = checkIfContinuousTree(root);
        System.out.print("Continuous tree : " + status);
    }

    public static boolean checkIfContinuousTree(TreeNode root) {

        if(root == null || (root.getLeft() == null && root.getRight() == null))
            return true;

        boolean l = true;
        boolean r = true;

        if(root.getLeft() != null)
            l = Math.abs(root.getData() - root.getLeft().getData()) == 1;

        if(root.getRight() != null)
            r = Math.abs(root.getData() - root.getRight().getData()) == 1;

        return l && r && checkIfContinuousTree(root.getLeft()) && checkIfContinuousTree(root.getRight());
    }
}
