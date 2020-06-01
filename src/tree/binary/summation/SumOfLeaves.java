package tree.binary.summation;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class SumOfLeaves {

    public static void main(String[] args) {

        Holder holder = new Holder();
        sumOfLeftLeaves(DSUtils.getTreeWithSmallNumbers().getRoot(), holder);
        System.out.print("Sum of left leaves : " + holder.getX());

        holder = new Holder();
        sumOfRightLeaves(DSUtils.getTreeWithSmallNumbers().getRoot(), holder);
        System.out.print("\n\nSum of right leaves : " + holder.getX());

        holder = new Holder();
        sumOfAllLeaves(DSUtils.getTreeWithSmallNumbers().getRoot(), holder);
        System.out.print("\n\nSum of all leaves : " + holder.getX());

        holder = new Holder();
        sumOfAllLeavesAtMaxDepth(DSUtils.getTreeWithSmallNumbers().getRoot(),0, holder);
        System.out.print("\n\nSum of leaves at max depth : " + holder.getX());

        holder = new Holder();
        sumOfAllLeavesAtMinDepth(DSUtils.getTreeWithSmallNumbers().getRoot(),0, holder);
        System.out.print("\n\nSum of leaves at min depth : " + holder.getX());

    }

    public static void sumOfLeftLeaves(TreeNode root, Holder holder) {

        if(root == null)
            return;

        if(root.getLeft() != null && root.getLeft().getLeft() == null && root.getLeft().getRight() == null)
            holder.setX(holder.getX() + root.getLeft().getData());

        sumOfLeftLeaves(root.getLeft(), holder);
        sumOfLeftLeaves(root.getRight(), holder);
    }

    public static void sumOfRightLeaves(TreeNode root, Holder holder) {

        if(root == null)
            return;

        if(root.getRight() != null && root.getRight().getLeft() == null && root.getRight().getRight() == null)
            holder.setX(holder.getX() + root.getRight().getData());

        sumOfRightLeaves(root.getLeft(), holder);
        sumOfRightLeaves(root.getRight(), holder);
    }

    public static void sumOfAllLeaves(TreeNode root, Holder holder) {

        if(root == null)
            return;

        if(root.getLeft() == null && root.getRight() == null)
            holder.setX(holder.getX() + root.getData());

        sumOfAllLeaves(root.getLeft(), holder);
        sumOfAllLeaves(root.getRight(), holder);
    }

    public static void sumOfAllLeavesAtMaxDepth(TreeNode root, int level, Holder h) {
        if(root == null)
            return;

        if(root.getLeft() == null && root.getRight() == null) {

            if(h.getLevel() == 0 || h.getLevel() < level) {
                h.setLevel(level);
                h.setX(root.getData());
            } else if( h.getLevel() == level) {
                h.setX(h.getX() + root.getData());
            }
        }

        sumOfAllLeavesAtMaxDepth(root.getLeft(), level + 1, h);
        sumOfAllLeavesAtMaxDepth(root.getRight(), level + 1, h);
    }

    public static void sumOfAllLeavesAtMinDepth(TreeNode root, int level, Holder h) {
        if(root == null)
            return;

        if(root.getLeft() == null && root.getRight() == null) {

            if(h.getLevel() == 0 || h.getLevel() > level) {
                h.setLevel(level);
                h.setX(root.getData());
            } else if( h.getLevel() == level) {
                h.setX(h.getX() + root.getData());
            }
        }

        sumOfAllLeavesAtMinDepth(root.getLeft(), level + 1, h);
        sumOfAllLeavesAtMinDepth(root.getRight(), level + 1, h);
    }

}
