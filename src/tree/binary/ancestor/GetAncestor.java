package tree.binary.ancestor;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;

public class GetAncestor {

    public static void main(String[] args) {

        List<TreeNode> ls = getAncestorOfNode(DSUtils.getPerfectBinaryTree3Levels().getRoot(),new TreeNode(39));

        System.out.print("Ancestor : ");
        ls.forEach(n -> {
            System.out.print("\t" + n.getData() + "\t|");
        });
    }

    public static List<TreeNode> getAncestorOfNode(TreeNode root, TreeNode node) {

        List<TreeNode> ls = new ArrayList<>();
        getAncestorOfNode(root, node,ls);
        if(!ls.isEmpty())
            ls.remove(ls.size() - 1);
        return ls;
    }

    private static void getAncestorOfNode(TreeNode root, TreeNode node, List<TreeNode> ls) {

        if(root == null || ls.contains(node))
            return;

        ls.add(root);

        if(root.getData() == node.getData())
            return;

        getAncestorOfNode(root.getLeft(), node, ls);
        getAncestorOfNode(root.getRight(), node, ls);

        if(!ls.isEmpty() && !ls.contains(node))
            ls.remove(ls.size() - 1);
    }
}
