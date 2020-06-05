package tree.binary.ancestor;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class KthAncestor {

    private static int k = 2;

    public static void main(String[] args) {

        TreeNode kThAncestor = getKthAncestorOfNode(DSUtils.getPerfectBinaryTree3Levels().getRoot(),new TreeNode(39));

        if(kThAncestor != null)
            System.out.print(kThAncestor.getData());
    }

    private static TreeNode getKthAncestorOfNode(TreeNode root,TreeNode node) {

        return null;
    }
}
