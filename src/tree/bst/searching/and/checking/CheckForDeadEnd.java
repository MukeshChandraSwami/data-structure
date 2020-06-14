package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class CheckForDeadEnd {

    public static void main(String[] args) {

        boolean status = check(DSUtils.getBST().getRoot(), 1, Integer.MAX_VALUE);
        System.out.println(status);
    }

    public static boolean check(TreeNode root, int min, int max) {
        if(root == null)
            return false;

        if(min == max)
            return true;

        return check(root.getLeft(), min, root.getData() - 1)
                || check(root.getRight(), root.getData() + 1, max);
    }
}
