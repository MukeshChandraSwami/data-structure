package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

/**
 * https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 */
public class ConstructTreeForHoldingSumOfChildren {

    public static void main(String[] args) {
        TreeNode root = DSUtils.getTreeWithSmallNumbers().getRoot();

        convertToHoldSumOfChildren(root);

        TraverseWithoutRecursion.preOrderTraversal(root);
    }

    public static int convertToHoldSumOfChildren(TreeNode node) {

        if(node == null)
            return 0 ;

        int old = node.getData();

        node.setData(convertToHoldSumOfChildren(node.getLeft()) + convertToHoldSumOfChildren(node.getRight()));

        return old + node.getData();
    }
}
