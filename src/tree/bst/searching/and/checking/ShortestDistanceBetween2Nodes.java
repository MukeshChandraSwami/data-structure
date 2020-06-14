package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class ShortestDistanceBetween2Nodes {

    public static void main(String[] args) {

        int distance = findShortestDistance(DSUtils.getBST().getRoot(), new TreeNode(6), new TreeNode(18));
        System.out.print("\n\nDistance : " + distance);
    }

    private static int findShortestDistance(TreeNode root, TreeNode n1, TreeNode n2) {
        TreeNode lca = getLCA(root, n1, n2);
        System.out.print("LCA : " + lca.getData());
        return getDistanceBetweenTwoNodes(lca, n1) + getDistanceBetweenTwoNodes(lca, n2) - 1;
    }

    private static TreeNode getLCA(TreeNode root, TreeNode n1, TreeNode n2) {

        if(root == null || n1 == null || n2 == null)
            return null;

        if(n1.getData() < root.getData() && n2.getData() < root.getData())
            return getLCA(root.getLeft(), n1, n2);

        if(n1.getData() > root.getData() && n2.getData() > root.getData())
            return getLCA(root.getRight(), n1, n2);

        return root;
    }

    private static int getDistanceBetweenTwoNodes(TreeNode root, TreeNode n) {

        if(root == null)
            return 0;

        return 1 +
                (n.getData() < root.getData() ? getDistanceBetweenTwoNodes(root.getLeft(), n) : 0) +
                (n.getData() > root.getData() ? getDistanceBetweenTwoNodes(root.getRight(), n) : 0);
    }
}
