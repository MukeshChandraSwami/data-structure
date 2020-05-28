package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

/**
 * https://www.geeksforgeeks.org/check-sum-covered-uncovered-nodes-binary-tree/
 */
public class CheckSumOfCoveredAndUncoveredNodes {

    public static void main(String[] args) {

        boolean status = checkSumOfCoveredNodesAndUncoveredNodes(DSUtils.getPerfectBinaryTree2Levels().getRoot());
        System.out.print("Sum of Covered Nodes = Sum of Uncovered Nodes -> " + status);
    }

    public static boolean checkSumOfCoveredNodesAndUncoveredNodes(TreeNode root) {

        int allNodesSum = getSumOfAllNodes(root);

        int leftBoundarySum = getSumOfLeftBoundary(root.getLeft());

        int rightBoundarySum = getSumOfRightBoundary(root.getRight());

        return allNodesSum == leftBoundarySum + rightBoundarySum;
    }

    private static int getSumOfRightBoundary(TreeNode root) {
        if(root == null)
            return 0;

        if(root.getLeft() == null && root.getRight() == null)
            return root.getData();

        if(root.getRight() != null)
            return root.getData() + getSumOfRightBoundary(root.getRight());
        else
            return root.getData() + getSumOfRightBoundary(root.getLeft());
    }

    private static int getSumOfLeftBoundary(TreeNode root) {
        if(root == null)
            return 0;

        if(root.getLeft() == null && root.getRight() == null)
            return root.getData();

        if(root.getLeft() != null)
            return root.getData() + getSumOfLeftBoundary(root.getLeft());
        else
            return root.getData() + getSumOfLeftBoundary(root.getRight());
    }

    private static int getSumOfAllNodes(TreeNode root) {

        if(root == null)
            return 0;
        int d = root.getData();

        return d + getSumOfAllNodes(root.getLeft()) + getSumOfAllNodes(root.getRight());
    }
}
