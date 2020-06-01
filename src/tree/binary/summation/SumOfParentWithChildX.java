package tree.binary.summation;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class SumOfParentWithChildX {


    public static void main(String[] args) {

        TreeNode root = DSUtils.getTreeWithSmallNumbers().getRoot();
        Holder h = new Holder();
        sum(root, h , 16);

        System.out.print("Sum : " + h.getX());
    }

    private static void sum(TreeNode root, Holder h, int i) {

        if(root == null)
            return;

        if((root.getLeft() != null && root.getLeft().getData() == i)
                || (root.getRight() != null && root.getRight().getData() == i))
            h.setX(h.getX() + root.getData());

        sum(root.getLeft(), h, i);
        sum(root.getRight(), h, i);
    }
}
