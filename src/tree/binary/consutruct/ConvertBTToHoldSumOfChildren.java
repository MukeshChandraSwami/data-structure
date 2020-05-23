package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

/**
 * https://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 */
public class ConvertBTToHoldSumOfChildren {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTree().getRoot();
        convertTreeToHoldSumOgChildren(root);
        TraverseWithoutRecursion.preOrderTraversal(root);
    }

    public static void convertTreeToHoldSumOgChildren(TreeNode node) {

        if(node == null || (node.getLeft() == null && node.getRight() == null))
            return;

        convertTreeToHoldSumOgChildren(node.getLeft());
        convertTreeToHoldSumOgChildren(node.getRight());

        int l = 0;
        int r = 0;

        if(node.getLeft() != null)
            l = node.getLeft().getData();

        if(node.getRight() != null)
            r = node.getRight().getData();

        int diff = (l + r) - node.getData();

        if(diff > 0)
            node.setData(node.getData() + diff);

        if(diff < 0)
            increment(node,-diff);
    }

    private static void increment(TreeNode node, int i) {

        if(node.getLeft() != null) {
            node.getLeft().setData(node.getLeft().getData() + i);
            increment(node.getLeft(), i);
        } else if(node.getRight() != null) {
            node.getRight().setData(node.getRight().getData() + i);
            increment(node.getRight(), i);
        }
    }
}
