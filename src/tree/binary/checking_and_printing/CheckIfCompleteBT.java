package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfCompleteBT {

    public static void main(String[] args) {

        boolean status = checkForCompleteBtViaRecursion(DSUtils.getPerfectBinaryTree2Levels().getRoot());
        System.out.print("Perfect BT : " + status);
    }

    public static boolean checkForCompleteBtViaRecursion(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leafFound = false;

        while(!queue.isEmpty()) {

            TreeNode node = queue.remove();

            if(node.getLeft() == null && node.getRight() != null)
                return false;

            if(leafFound && (node.getLeft() != null || node.getRight() != null))
                return false;

            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            } else {
                leafFound = true;
            }

            if(node.getRight() != null) {
                queue.add(node.getRight());
            } else {
                leafFound = true;
            }
        }
        return true;
    }
}
