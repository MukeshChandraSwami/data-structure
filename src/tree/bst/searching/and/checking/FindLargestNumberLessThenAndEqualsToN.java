package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class FindLargestNumberLessThenAndEqualsToN {

    public static void main(String[] args) {

        int n = 13;
        int number = find(DSUtils.getBST().getRoot(), n);
        System.out.println(number);
    }

    public static int find(TreeNode root, int n) {
        if(root == null)
            return Integer.MIN_VALUE;

        if(root.getData() == n)
            return root.getData();

        if(root.getData() < n) {
            int l = find(root.getRight(), n);
            if(l == Integer.MIN_VALUE) {
                return root.getData();
            } else {
                return l;
            }
        } else if(root.getData() > n) {
            return find(root.getLeft(), n);
        }
        return Integer.MIN_VALUE;
    }
}
