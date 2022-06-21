package tree.bst.construction.and.conversion;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

public class ConvertBSTtoGreatestSumBST {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getBST().getRoot();
        convert(root);

        TraverseWithoutRecursion.inOrderTraversal1(root);
    }

    public static void convert(TreeNode root) {

        convert(root,new Holder());
    }

    private static void convert(TreeNode root, Holder h) {

        if(root == null)
            return;

        convert(root.getRight(), h);

        int d = root.getData();
        h.setX(h.getX() + d);
        root.setData(h.getX() - d);

        convert(root.getLeft(), h);
    }
}
