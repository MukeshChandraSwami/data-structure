package tree.bst.searching.and.checking;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class FindClosestElement {

    public static void main(String[] args) {

        Holder h = new Holder(Integer.MAX_VALUE);
        int k = 11;
        getClosestElement(DSUtils.getBST().getRoot(), k, h);
        System.out.println("Closest element of " + k + " is : " + h.getY());
    }

    public static void getClosestElement(TreeNode root, int k, Holder h) {
        if(root == null)
            return;

        int diff = Math.abs(root.getData() - k);
        if(diff <= h.getX()) {
            h.setX(diff);
            h.setY(root.getData());
        }
        getClosestElement(root.getLeft(), k, h);
        getClosestElement(root.getRight(), k, h);
    }
}
