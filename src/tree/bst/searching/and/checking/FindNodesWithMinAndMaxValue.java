package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class FindNodesWithMinAndMaxValue {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getBST().getRoot();
        TreeNode min = getMin(root);
        TreeNode max = getMax(root);

        System.out.print("Min : " + min.getData());
        System.out.print("\n\nMax : " + max.getData());
    }

    private static TreeNode getMin(TreeNode root) {

        if(root == null)
            return null;

        if(root.getLeft() == null)
            return root;

        return getMin(root.getLeft());
    }

    private static TreeNode getMax(TreeNode root) {

        if(root == null)
            return null;

        if(root.getRight() == null)
            return root;
        return getMax(root.getRight());
    }

}
