package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfFullBT {

    public static void main(String[] args) {

        boolean status = checkForFullBTviaIteration(DSUtils.getPerfectBinaryTree2Levels().getRoot());
        System.out.print("Full BT : " + status);
    }

    public static boolean checkForFullBTviaRecursion(TreeNode root) {

        if(root == null || (root.getLeft() == null && root.getRight() == null))
            return true;

        if((root.getLeft() == null && root.getRight() != null) || root.getLeft() != null && root.getRight() == null)
            return false;

        return checkForFullBTviaRecursion(root.getLeft()) && checkForFullBTviaRecursion(root.getRight());
    }

    public static boolean checkForFullBTviaIteration(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            TreeNode node = queue.remove();

            if((node.getLeft() == null && node.getRight() != null) || node.getLeft() != null && node.getRight() == null)
                return false;

            if(node.getLeft() != null) {
                queue.add(node.getLeft());
                queue.add(node.getRight());
            }
        }

        return true;
    }

}
