package tree.binary;

import tree.binary.common.TreeNode;
import utils.DSUtils;

/**
 * https://www.geeksforgeeks.org/foldable-binary-trees/
 */
public class FoldableBT {

    public static void main(String[] args) {

        TreeNode l = DSUtils.getContinuousTree().getRoot().getLeft();
        TreeNode r = DSUtils.getContinuousTree().getRoot().getRight();
        boolean status = checkIfFoldableBT(l,r);
        System.out.println("Foldable BT : " + status);
    }

    public static boolean checkIfFoldableBT(TreeNode l, TreeNode r) {

        if(l == null && r == null)
            return true;

        if(l == null || r ==null)
            return false;

        return checkIfFoldableBT(l.getLeft(), r.getRight()) && checkIfFoldableBT(l.getRight(), r.getLeft());
    }
}
