package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

/**
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 */
public class CheckIfSumTree {

    public static void main(String[] args) {

        StatusHolder status = checkIfSumTree(DSUtils.getSumBT().getRoot());
        System.out.print("Sum tree : " + status.getStatus());
    }

    public static StatusHolder checkIfSumTree(TreeNode root) {

        if(root == null || (root.getLeft() == null && root.getRight() == null))
            return new StatusHolder(true, 0);

        int l = 0;
        int r = 0;

        if(root.getLeft() != null)
            l = root.getLeft().getData();

        if(root.getRight() != null)
            r = root.getRight().getData();

        StatusHolder ls = checkIfSumTree(root.getLeft());
        StatusHolder rs = checkIfSumTree(root.getRight());



        return new StatusHolder(ls.getSum() + rs.getSum() + l + r == root.getData() && ls.getStatus() && rs.getStatus(), ls.getSum() + rs.getSum() + l + r);
    }

    private static class StatusHolder {

        private boolean status;
        private int sum;

        public StatusHolder(boolean status, int sum) {
            this.status = status;
            this.sum = sum;
        }

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }
}
