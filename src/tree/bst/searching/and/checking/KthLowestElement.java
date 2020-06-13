package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class KthLowestElement {

    private static int counter = 0;
    public static void main(String[] args) {

        TreeNode root = DSUtils.getBST().getRoot();
        int k = 6;
        int element = getKthLowestNumber(root, k);
        System.out.println(element);
    }

    private static int getKthLowestNumber(TreeNode root, int k) {
        if(root == null)
            return Integer.MIN_VALUE;

        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;
        if(root.getLeft() != null)
           l = getKthLowestNumber(root.getLeft(), k);

        ++counter;
        if(counter == k)
            return root.getData();

        if(root.getRight() != null)
            r = getKthLowestNumber(root.getRight(), k);

        return Math.max(l,r);
    }
}
