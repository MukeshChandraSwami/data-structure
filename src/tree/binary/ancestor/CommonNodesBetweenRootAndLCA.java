package tree.binary.ancestor;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.List;

public class CommonNodesBetweenRootAndLCA {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getPerfectBinaryTree3Levels().getRoot();
        TreeNode lca = LeastCommonAncestorOf2Nodes.lcaViaRecursion(root, new TreeNode(84), new TreeNode(99));
        List<TreeNode> ancestor = GetAncestor.getAncestorOfNode(root, lca);

        System.out.print("Ancestor : ");
        ancestor.forEach(n -> {
            System.out.print("\t" + n.getData() + "\t|");
        });

    }
}
