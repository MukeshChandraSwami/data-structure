package tree.binary.ancestor;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestorOf2Nodes {

    private static boolean flag1 = true;
    private static boolean flag2 = true;

    public static void main(String[] args) {

        TreeNode root = DSUtils.getPerfectBinaryTree3Levels().getRoot();
        TreeNode node1 = new TreeNode(99);
        TreeNode node2 = new TreeNode(390);

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        lcaViaList(root, node1, node2, l1, l2);
        int lca = 0;
        for(int i = 0; i < (l1.size() < l2.size() ? l1.size() : l2.size()); i++) {
            if(l1.get(i) != l2.get(i)) {
                i = i - 1;
                if(i < 0)
                    lca = Integer.MIN_VALUE;
                else
                    lca = l1.get(i);
                break;
            }
        }
        System.out.print("Least common ancestor [List] : " + lca);

        lca = lcaViaRecursion(root, node1, node2).getData();
        System.out.print("\n\nLeast common ancestor [Recursion] : " + lca);
    }

    public static void lcaViaList(TreeNode root, TreeNode node1, TreeNode node2, List<Integer> l1,
                                  List<Integer> l2) {

        if(root == null || (!flag1 && !flag2))
            return;

        if(flag1)
            l1.add(root.getData());
        if(flag2)
            l2.add(root.getData());

        if(root.getData() == node1.getData()) {
            flag1 = false;
        }

        if(root.getData() == node2.getData()) {
            flag2 = false;
        }

        lcaViaList(root.getLeft(), node1, node2, l1,l2);
        lcaViaList(root.getRight(), node1, node2, l1,l2);

        if(flag1)
            l1.remove(l1.size() - 1);
        if(flag2)
            l2.remove(l2.size() - 1);
    }

    public static TreeNode lcaViaRecursion(TreeNode root, TreeNode node1, TreeNode node2) {

        if(root == null)
            return null;

        if(root.getData() == node1.getData() || root.getData() == node2.getData())
            return root;

        TreeNode l = lcaViaRecursion(root.getLeft(),  node1, node2);
        TreeNode r = lcaViaRecursion(root.getRight(), node1, node2);

        if(l != null && r != null)
            return root;

        return l != null ? l : r;
    }
}
