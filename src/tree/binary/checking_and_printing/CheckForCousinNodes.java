package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

public class CheckForCousinNodes {

    public static void main(String[] args) {
        boolean status = checkIf2NodesAreCousins(DSUtils.getPerfectBinaryTree3Levels().getRoot(), new TreeNode(31), new TreeNode(91));
        System.out.print("Cousin Nodes : " + status);
    }

    public static boolean checkIf2NodesAreCousins(TreeNode root, TreeNode node1, TreeNode node2) {

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(root);

        while(!q1.isEmpty() || !q2.isEmpty()) {

            while(!q1.isEmpty()) {

                if(q1.size() >= 2 && q1.contains(node1) && q1.contains(node2))
                    return true;

                TreeNode removed = q1.remove();
                TreeNode left = null;
                TreeNode right = null;

                if(removed.getLeft() != null) {
                    left = removed.getLeft();
                    q2.add(left);
                }

                if(removed.getRight() != null) {
                    right = removed.getRight();
                    q2.add(right);
                }

                // Return false if parent of both these nodes is same.
                if(checkForEquality(left,right,node1,node2))
                    return false;
            }


            while(!q2.isEmpty()) {

                if(q2.size() >= 2 && q2.contains(node1) && q2.contains(node2))
                    return true;

                TreeNode removed = q2.remove();
                TreeNode left = null;
                TreeNode right = null;

                if(removed.getLeft() != null) {
                    left = removed.getLeft();
                    q1.add(left);
                }

                if(removed.getRight() != null) {
                    right = removed.getRight();
                    q1.add(right);
                }

                // Return false if parent of both these nodes is same.
                if(checkForEquality(left,right,node1,node2))
                    return false;
            }
        }

        return false;
    }

    private static boolean checkForEquality(TreeNode left, TreeNode right, TreeNode node1, TreeNode node2) {
        return left != null && right != null && ((left.equals(node1) && right.equals(node2)) || (left.equals(node2) && right.equals(node1)));
    }
}
