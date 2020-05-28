package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.LevelOrderTraversal;
import utils.DSUtils;

/**
 * https://www.geeksforgeeks.org/convert-given-binary-tree-tree-holds-logical-property/
 */
public class ConvertBTToFulfilLogicalANDProperties {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getInvalidLogicalAND().getRoot();
        System.out.print("Level order traversal before : ");
        LevelOrderTraversal.levelOrderTraversal(root);

        convertBinaryTreeToHoldLogicalANDProperty(root);

        System.out.print("\n\nLevel order traversal after : ");
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public static void convertBinaryTreeToHoldLogicalANDProperty(TreeNode node) {

        if(node == null || (node.getLeft() == null && node.getRight() == null))
            return;

        convertBinaryTreeToHoldLogicalANDProperty(node.getLeft());
        convertBinaryTreeToHoldLogicalANDProperty(node.getRight());

        int l = node.getLeft().getData();
        int r = node.getRight().getData();

        node.setData(l * r);
    }
}
