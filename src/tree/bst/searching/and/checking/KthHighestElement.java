package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class KthHighestElement {

    private static int counter = 0;

    public static void main(String[] args) {

        int k = 2;
        int t = getKthHighestElement(DSUtils.getBST().getRoot(), k);
        System.out.println(k + "th highest element : " + t);
    }

    public static int getKthHighestElement(TreeNode root, int k) {

        if(root == null || counter > k)
            return Integer.MIN_VALUE;

        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;

        if(root.getRight() != null)
            r = getKthHighestElement(root.getRight(), k);

        ++counter;
        if(counter == k)
            return root.getData();

        if(root.getLeft() != null)
            l = getKthHighestElement(root.getLeft(), k);

        return Math.max(l,r);
    }
}
