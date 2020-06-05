package tree.binary.ancestor;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class FindDistanceBetween2Nodes {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getPerfectBinaryTree3Levels().getRoot();

        int distance = getDistance(root, new TreeNode(39), new TreeNode(87));
        System.out.print("Distance : " + distance);
    }

    public static int getDistance(TreeNode root, TreeNode node1, TreeNode node2) {

        TreeNode lca = LeastCommonAncestorOf2Nodes.lcaViaRecursion(root, node1, node2);
        return getLevel(lca, node1, 0) + getLevel(lca, node2, 0);
    }

    private static int getLevel(TreeNode root, TreeNode node, int level) {

        if(root == null)
            return -1;

        if(node.getData() == root.getData())
            return level;

        int ll = getLevel(root.getLeft(), node, level + 1);
        if(ll == -1)
            return getLevel(root.getRight(), node, level + 1);

        return ll;
    }
}
