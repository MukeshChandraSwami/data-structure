package tree.binary.summation;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class MaxSumAdjacentLevels {

    public static void main(String[] args) {

        Holder h = new Holder();
        getSumOfAdjacentLevels(DSUtils.getTreeWithSmallNumbers().getRoot(), h, 0);
        System.out.print("Max sum : " + Math.max(h.getX(), h.getY()));
    }

    public static void getSumOfAdjacentLevels(TreeNode root, Holder h, int level) {

        if(root == null)
            return;

        if(level % 2 == 0)
            h.setX(h.getX() + root.getData());
        else
            h.setY(h.getY() + root.getData());

        getSumOfAdjacentLevels(root.getLeft(), h, level + 1);
        getSumOfAdjacentLevels(root.getRight(), h, level + 1);
    }
}
