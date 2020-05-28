package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

public class CheckForSameLeafTraversal {

    public static void main(String[] args) {


        Queue<Integer> leafTraversal1 = getLeafTraversal(DSUtils.getTree().getRoot());
        System.out.print("Leaves of first tree : " + leafTraversal1);

        Queue<Integer> leafTraversal2 = getLeafTraversal(DSUtils.getTreeWithSmallNumbers().getRoot());
        System.out.print("\n\nLeaves of first tree : " + leafTraversal2);

        System.out.print("\n\nLeaf traversal is same : " + leafTraversal1.equals(leafTraversal2));

    }

    public static Queue<Integer> getLeafTraversal(TreeNode node) {

        Queue<Integer> leafs = new LinkedList<>();

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(node);

        while(!q1.isEmpty()) {

            TreeNode n = q1.remove();

            if(n.getLeft() == null && n.getRight() == null)
                leafs.add(n.getData());

            if(n.getLeft() != null)
                q1.add(n.getLeft());

            if(n.getRight() != null)
                q1.add(n.getRight());
        }

        return leafs;
    }
}
