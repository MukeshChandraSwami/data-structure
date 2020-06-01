package tree.binary.summation;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class SumOfHeightsOfAllNodes {

    public static void main(String[] args) {

        Holder h = new Holder();
        int height = sumOfHeights(DSUtils.getTreeWithSmallNumbers().getRoot(), h);
        System.out.print("Height : " + height);
        System.out.print("\n\nSum of heights : " + h.getX());
    }

    public static int sumOfHeights(TreeNode root, Holder holder) {

        if(root == null)
            return 0;

        int lh = sumOfHeights(root.getLeft(), holder);
        int rh = sumOfHeights(root.getRight(), holder);

        int h = Math.max(lh,rh) + 1;

        holder.setX(holder.getX() + h);
        return h;
    }
}
