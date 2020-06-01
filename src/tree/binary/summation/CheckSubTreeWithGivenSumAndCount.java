package tree.binary.summation;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class CheckSubTreeWithGivenSumAndCount {

    public static void main(String[] args) {

        Holder h = new Holder();
        int sum = 40;
        checkForSum(DSUtils.getTreeWithSmallNumbers().getRoot(), h, sum);

        System.out.print(h.isFlag() + " " + h.getX());
    }

    public static int checkForSum(TreeNode root, Holder h, int sum) {

        if(root == null)
            return 0;

        int s = root.getData() + checkForSum(root.getLeft(), h, sum) + checkForSum(root.getRight(), h, sum);

        if(s == sum) {
            h.setFlag(true);
            h.setX(h.getX() + 1);
        }

        return s;
    }
}
