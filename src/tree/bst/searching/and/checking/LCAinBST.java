package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class LCAinBST {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getBST().getRoot();
        TreeNode lca = lcaRecursive(root, new TreeNode(12), new TreeNode(9));
        System.out.print("Common LCA [Recursive]: " + lca.getData());

        lca = lcaIterative(root, new TreeNode(12), new TreeNode(17));
        System.out.print("\n\nCommon LCA [Iterative]: " + lca.getData());
    }

    public static TreeNode lcaRecursive(TreeNode root, TreeNode n1, TreeNode n2) {

        if(root == null || n1 == null || n2 == null)
            return null;

        if(n1.getData() < root.getData() && n2.getData() < root.getData()) {
            return lcaRecursive(root.getLeft(), n1, n2);
        } else if(n1.getData() > root.getData() && n2.getData() > root.getData()) {
            return lcaRecursive(root.getRight(), n1, n2);
        }

        return root;
    }

    public static TreeNode lcaIterative(TreeNode root, TreeNode n1, TreeNode n2) {

        TreeNode lca = null;

        while(root != null) {
            if(n1.getData() < root.getData() && n2.getData() < root.getData()) {
                root = root.getLeft();
            } else if(n1.getData() > root.getData() && n2.getData() > root.getData()) {
                root = root.getRight();
            } else {
                lca = root;
                break;
            }
        }

        return lca;
    }
}
