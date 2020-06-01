package tree.binary.summation;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class SumOfAllNode {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTreeWithSmallNumbers().getRoot();
        int sum = getSumOfAllNodes1(root);
        System.out.println(sum);
    }

    public static int getSumOfAllNodes2(TreeNode node) {
        if(node == null)
            return 0;

        return node.getData() + getSumOfAllNodes2(node.getLeft()) + getSumOfAllNodes2(node.getRight());
    }

    public static int getSumOfAllNodes1(TreeNode node) {

        Holder h = new Holder();
        getSumOfAllNodes1(node,h);

        return h.getSum();
    }

    private static void getSumOfAllNodes1(TreeNode node, Holder h) {

        if(node == null)
            return;

        h.setSum(h.getSum() + node.getData());
        getSumOfAllNodes1(node.getLeft(),h);
        getSumOfAllNodes1(node.getRight(),h);
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
