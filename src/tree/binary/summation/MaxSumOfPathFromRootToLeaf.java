package tree.binary.summation;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class MaxSumOfPathFromRootToLeaf {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTreeWithSmallNumbers().getRoot();
        Holder h = new Holder();
        getSum(root, h, 0, "");

        System.out.print(h.getS().substring(0,h.getS().length()-2) + " = " + h.getX());
    }

    public static void getSum(TreeNode root, Holder h, int sum, String s) {

        if(root == null) {

            if(h.getX() < sum) {
                h.setX(sum);
                h.setS(s);
            }
            return;
        }

        getSum(root.getLeft(), h,sum + root.getData(), s + root.getData() + "->");
        getSum(root.getRight(), h,sum + root.getData(), s + root.getData() + "->");
    }
}
