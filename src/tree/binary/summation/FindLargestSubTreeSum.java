package tree.binary.summation;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class FindLargestSubTreeSum {

    public static void main(String[] args) {

        Holder h = new Holder();
        findSum(DSUtils.getTreeWithSmallNumbers().getRoot(),h);

        System.out.print("Max sum : " + h.getX());
    }

    public static int findSum(TreeNode root, Holder h) {

        if(root == null)
            return 0;

        int sum = root.getData() + findSum(root.getLeft(), h) + findSum(root.getRight(), h);

        h.setX(Math.max(h.getX(), sum));

        return sum;
    }
}
