package tree.binary.summation;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class SumOfLongestPathFromRootToLeaf {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTreeWithSmallNumbers().getRoot();

        Holder h = new Holder();
        findSumOfLongestPath(root, h, 0, 0);

        System.out.print("Sum of longest path from Root to Leaf : " + h.getX());
    }

    public static void findSumOfLongestPath(TreeNode root, Holder h, int level, int sum) {

        if(root == null) {

            if(h.getLevel() < level) {
                h.setX(sum);
                h.setLevel(level);
            }

            return;
        }

        findSumOfLongestPath(root.getLeft(), h, level + 1, sum + root.getData());
        findSumOfLongestPath(root.getRight(), h, level + 1, sum + root.getData());
    }
}
