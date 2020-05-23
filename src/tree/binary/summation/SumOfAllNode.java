package tree.binary.summation;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class SumOfAllNode {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTreeWithSmallNumbers().getRoot();
        int sum = getSumOfAllNodes(root);
        System.out.println(sum);
    }

    public static int getSumOfAllNodes(TreeNode node) {

        Holder h = new Holder();
        getSumOfAllNodes(node,h);

        return h.getSum();
    }

    private static void getSumOfAllNodes(TreeNode node, Holder h) {

        if(node == null)
            return;

        h.setSum(h.getSum() + node.getData());
        getSumOfAllNodes(node.getLeft(),h);
        getSumOfAllNodes(node.getRight(),h);
    }

    private static class Holder{

        private int sum = 0;

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }
}
