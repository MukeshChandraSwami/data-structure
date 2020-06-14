package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class SumOfKSmallestNumbers {

    private static int counter = 0;

    public static void main(String[] args) {

        int k = 2;
        int sum = sum(DSUtils.getBST().getRoot(), k);
        System.out.println(sum);
    }

    public static int sum(TreeNode root, int k) {
        if(root == null || counter >= k)
            return 0;

        int sum = 0;
        int l = sum(root.getLeft(), k);
        
        int r = sum(root.getLeft(), k);


        return l + r;
    }
}
